package com.veterinaria.veterinariajava.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.ProductoVentaDTO;
import com.veterinaria.veterinariajava.DTO.VentasDetallesResponseDTO;
import com.veterinaria.veterinariajava.DTO.VentasResponseDTO;
import com.veterinaria.veterinariajava.DTO.VentasRequestDTO;
import com.veterinaria.veterinariajava.Tables.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;

import com.veterinaria.veterinariajava.Repository.ProductosRepository;
import com.veterinaria.veterinariajava.Repository.VentasRepository;

@Service
public class VentasServices {

  @Autowired
  private VentasRepository ventasRepository;

  @Autowired
  private EmpleadosRepository empleadosRepository;

  @Autowired
  private ProductosRepository productosRepository;

  @Autowired
  private ProductosServices productosServices;

  @Autowired
  private VentasDetallesServices ventasDetallesServices;

  @Autowired
  private EmpleadosServices empleadosServices;

  @Autowired
  private GananciaServices gananciaServices;

  @Autowired
  private SueldosMensualesServices sueldosMensualesServices;

  private VentasResponseDTO mapToEntity(Ventas ventas){
    List<VentasDetallesResponseDTO> detallesResponseDTOS = ventas.getDetallesList().stream()
            .map(d -> new VentasDetallesResponseDTO(
                    d.getProductos().getProductoId(),
                    d.getProductos().getNombreProducto(),
                    d.getCantidadProductoVendido(),
                    d.getPrecioUnitarioPorVenta(),
                    d.getSubtotal()
            )).toList();

    return new VentasResponseDTO(
            ventas.getVentaId(),
            ventas.getFecha(),
            ventas.getEmpleados().getEmpleadoId(),
            ventas.getEmpleados().getNombreEmpleado(),
            ventas.getDetallesList().stream().mapToDouble(VentasDetalles::getSubtotal).sum(),detallesResponseDTOS
    );
  }


  public List<VentasResponseDTO> obtenerTodasLasVentas() {
    return ventasRepository.findAll().stream()
            .map(this::mapToEntity).toList();
  }

  @Transactional
  public VentasResponseDTO registrarVentas(VentasRequestDTO dto) {

    Empleados empleados = empleadosRepository.findById(dto.getEmpleadoId()).
            orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

    Ventas ventas = new Ventas();
    ventas.setEmpleados(empleados);
    ventas.setFecha(LocalDateTime.now());

    Double total = 0.0;
    List<VentasDetalles> detalles = new ArrayList<>();

    for (ProductoVentaDTO p : dto.getProductos()) {

      Productos productos = productosRepository.findById(p.getProductoId()).
              orElseThrow(()-> new RuntimeException("Producto no encontrado"));

      productosServices.obtenerPorId(p.getProductoId());
      productosServices.descontarStock(p.getProductoId(), p.getCantidad());

      VentasDetalles ventasDetalles = ventasDetallesServices.crearDetalle(ventas, productos, p.getCantidad());
      detalles.add(ventasDetalles);

      total += ventasDetalles.getSubtotal();

    }

    ventas.setPrecioTotal(total);
    ventas.setDetallesList(detalles);
    Ventas ventaNueva = ventasRepository.save(ventas);

    double comision = calcularComision(empleados, total);

    sueldosMensualesServices.actualizarSueldoConVenta(empleados.getEmpleadoId(), comision);

    empleados.setTotalVentas(ventaNueva);

    return mapToEntity(ventaNueva);
  }
//    Productos productos = productosRepository.findById(dto.getProductoId()).
//            orElseThrow(()-> new RuntimeException("Producto no encontrado"));
//
//    if(productos.getStock() < dto.getCantidad()){
//      throw new IllegalStateException("No hay suficiente stock disponible");
//    }
//
//    //Calcular datos
//    double precioUnitario = productos.getPrecioVenta();
//    long cantidad = dto.getCantidad();
//    double total = precioUnitario * cantidad;
//    double comision = calcularComision(empleados, total);
//
//    //Actualizar stock y sueldo
//    productos.setStock(productos.getStock()-cantidad);
//    productosRepository.save(productos);
//
//    sueldosMensualesServices.actualizarSueldoConVenta(empleados.getEmpleadoId(), comision);
//
//    //actualizar tabla ganancias
//
//
//    //Guardar venta
//    Ventas nuevaVenta = new Ventas(productos, empleados, cantidad, precioUnitario, comision);
//
//    Ventas ventaGuardada = ventasRepository.save(nuevaVenta);
//
//    empleados.setTotalVentas(ventaGuardada);
//
//    //Devolver DTO



  @Transactional
//  public VentasResponseDTO actualizarVentas(Integer ventaId, Ventas nuevaData){
//
//    Ventas ventaExistente = ventasRepository.findById(ventaId)
//            .orElseThrow(()-> new RuntimeException("Venta no encontrada"));
//
//    Empleados empleados = empleadosRepository.findById(nuevaData.getEmpleados().getEmpleadoId())
//            .orElseThrow(()->new RuntimeException("Empleado no encontrado"));
//
//    Productos productos = productosRepository.findById(nuevaData.getProductos().getProductoId())
//            .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
//
//    long nuevaCantidad = nuevaData.getCantidadProductoVendido();
//
//    //Devolver stock anterior antes de calcular stock nuevo
//
//    Productos productoAnterior = ventaExistente.getProductos();
//    long cantidadAnterior = ventaExistente.getCantidadProductoVendido();
//    productoAnterior.setStock(productoAnterior.getStock() + cantidadAnterior);
//
//    if(productoAnterior.getStock() < nuevaCantidad){
//      throw new IllegalStateException("No hay suficiente stock para la venta");
//    }
//
//    double nuevoPrecioUnitario = productos.getPrecioCosto();
//    double nuevoTotal = nuevoPrecioUnitario * nuevaCantidad;
//    double nuevaComision = calcularComision(empleados, nuevoTotal);
//
//    productos.setStock(productos.getStock() - nuevaCantidad);
//
//    sueldosMensualesServices.actualizarSueldoConVenta(empleados.getEmpleadoId(), nuevaComision);
//
//    //actualizar datos
//
//    ventaExistente.setEmpleados(empleados);
//    ventaExistente.setProductos(productos);
//    ventaExistente.setCantidadProductoVendido(nuevaCantidad);
//    ventaExistente.setPrecioUnitarioPorVenta(nuevoPrecioUnitario);
//    ventaExistente.setComisionPorVenta(nuevaComision);
//
//    ventasRepository.save(ventaExistente);
//
//    return new VentasResponseDTO(
//            ventaExistente.getVentaId(),
//            ventaExistente.getProductos().getProductoId(),
//            ventaExistente.getProductos().getNombreProducto(),
//            ventaExistente.getEmpleados().getEmpleadoId(),
//            ventaExistente.getEmpleados().getTipoEmpleado(),
//            ventaExistente.getEmpleados().getNombreEmpleado(),
//            ventaExistente.getPrecioUnitarioPorVenta(),
//            ventaExistente.getCantidadProductoVendido(),
//            ventaExistente.getPrecioTotal(),
//            ventaExistente.getComisionPorVenta(),
//            ventaExistente.getFecha()
//    );
//
//
//  }

  public void eliminarVenta(Integer id){
    ventasRepository.deleteById(id);
  }

  private double calcularComision(Empleados empleados, double total) {
    return switch (empleados.getTipoEmpleado().toLowerCase()){
      case "veterinario" -> total * 0.15;
      case "recepcionista" -> total * 0.10;
      default -> 0.0;
    };
  }

}