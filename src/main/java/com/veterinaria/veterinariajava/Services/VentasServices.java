package com.veterinaria.veterinariajava.Services;

import java.util.List;

import com.veterinaria.veterinariajava.DTO.VentasResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;

import com.veterinaria.veterinariajava.Repository.ProductosRepository;
import com.veterinaria.veterinariajava.Repository.VentasRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;

import com.veterinaria.veterinariajava.Tables.Productos;
import com.veterinaria.veterinariajava.Tables.Ventas;

@Service
public class VentasServices {

  @Autowired
  private VentasRepository ventasRepository;

  @Autowired
  private EmpleadosRepository empleadosRepository;

  @Autowired
  private ProductosRepository productosRepository;

  @Autowired
  private  EmpleadosService empleadosService;

  public List<Ventas> obtenerTodasLasVentas() {
    return ventasRepository.findAll();
  }

  @Transactional
  public VentasResponseDTO registrarVentas(Ventas ventas) {

    Empleados empleados = empleadosRepository.findById(ventas.getEmpleados().getEmpleadoId()).
            orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

    Productos productos = productosRepository.findById(ventas.getProductos().getProductoId()).
            orElseThrow(()-> new RuntimeException("Producto no encontrado"));

    if(productos.getStock() < ventas.getCantidadProductoVendido()){
      throw new IllegalStateException("No hay suficiente stock disponible");
    }

    //Calcular datos
    double precioUnitario = productos.getPrecioUnitario();
    long cantidad = ventas.getCantidadProductoVendido();
    double total = precioUnitario * cantidad;
    double comision = calcularComision(empleados, total);

    //Actualizar stock y sueldo
    productos.setStock(productos.getStock()-cantidad);
    empleados.setComisionesTotal(empleados.getComisionesTotal() + comision);
    empleadosService.calcularSueldoFinal(empleados.getEmpleadoId());

    //Guardar venta
    Ventas nuevaVenta = new Ventas(productos, empleados, cantidad, precioUnitario, comision);
    ventasRepository.save(nuevaVenta);

    Ventas ventaCompleta = ventasRepository.findById(nuevaVenta.getVentaId())
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

    //Devolver DTO
    return new VentasResponseDTO(
            nuevaVenta.getProductos().getProductoId(),
            nuevaVenta.getProductos().getNombreProducto(),
            nuevaVenta.getEmpleados().getEmpleadoId(),
            nuevaVenta.getEmpleados().getTipoEmpleado(),
            nuevaVenta.getEmpleados().getNombreEmpleado(),
            nuevaVenta.getPrecioUnitarioPorVenta(),
            nuevaVenta.getCantidadProductoVendido(),
            nuevaVenta.getPrecioTotal(),
            nuevaVenta.getPrecioTotal()
    );

  }

  @Transactional
  public VentasResponseDTO actualizarVentas(Integer ventaId, Ventas nuevaData){

    Ventas ventaExistente = ventasRepository.findById(ventaId)
            .orElseThrow(()-> new RuntimeException("Venta no encontrada"));

    Empleados empleados = empleadosRepository.findById(nuevaData.getEmpleados().getEmpleadoId())
            .orElseThrow(()->new RuntimeException("Empleado no encontrado"));

    Productos productos = productosRepository.findById(nuevaData.getProductos().getProductoId())
            .orElseThrow(()-> new RuntimeException("Producto no encontrado"));

    long nuevaCantidad = nuevaData.getCantidadProductoVendido();

    //Devolver stock anterior antes de calcular stock nuevo

    Productos productoAnterior = ventaExistente.getProductos();
    long cantidadAnterior = ventaExistente.getCantidadProductoVendido();
    productoAnterior.setStock(productoAnterior.getStock() + cantidadAnterior);

    if(productoAnterior.getStock() < nuevaCantidad){
      throw new IllegalStateException("No hay suficiente stock para la venta");
    }

    double nuevoPrecioUnitario = productos.getPrecioUnitario();
    double nuevoTotal = nuevoPrecioUnitario * nuevaCantidad;
    double nuevaComision = calcularComision(empleados, nuevoTotal);

    productos.setStock(productos.getStock() - nuevaCantidad);
    empleados.setComisionesTotal(empleados.getComisionesTotal() + nuevaComision);
    empleadosService.calcularSueldoFinal(empleados.getEmpleadoId());

    //actualizar datos

    ventaExistente.setEmpleados(empleados);
    ventaExistente.setProductos(productos);
    ventaExistente.setCantidadProductoVendido(nuevaCantidad);
    ventaExistente.setPrecioUnitarioPorVenta(nuevoPrecioUnitario);
    ventaExistente.setComisionPorVenta(nuevaComision);

    ventasRepository.save(ventaExistente);

    return new VentasResponseDTO(
            ventaExistente.getProductos().getProductoId(),
            ventaExistente.getProductos().getNombreProducto(),
            ventaExistente.getEmpleados().getEmpleadoId(),
            ventaExistente.getEmpleados().getTipoEmpleado(),
            ventaExistente.getEmpleados().getNombreEmpleado(),
            ventaExistente.getPrecioUnitarioPorVenta(),
            ventaExistente.getCantidadProductoVendido(),
            ventaExistente.getPrecioTotal(),
            ventaExistente.getPrecioTotal()
    );


  }

  private double calcularComision(Empleados empleados, double total) {
    return switch (empleados.getTipoEmpleado().toLowerCase()){
      case "veterinario" -> total * 0.15;
      case "recepcionista" -> total * 0.10;
      default -> 0.0;
    };
  }

}