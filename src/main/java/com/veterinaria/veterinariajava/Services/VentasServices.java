package com.veterinaria.veterinariajava.Services;

import java.util.List;

import com.veterinaria.veterinariajava.DTO.VentasResponseDTO;
import com.veterinaria.veterinariajava.DTO.VentasRequestDTO;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
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
  private EmpleadosServices empleadosServices;

  @Autowired
  private GananciaServices gananciaServices;

  @Autowired
  private SueldosMensualesServices sueldosMensualesServices;

  private VentasResponseDTO mapToEntity(Ventas ventas){
    VentasResponseDTO dto = new VentasResponseDTO();
    dto.setVentaId(ventas.getVentaId());
    dto.setProductoId(ventas.getProductos().getProductoId());
    dto.setNombreProducto(ventas.getProductos().getNombreProducto());
    dto.setPrecioUnitario(ventas.getPrecioUnitarioPorVenta());
    dto.setPrecioTotal(ventas.getPrecioTotal());
    dto.setCantidad(ventas.getCantidadProductoVendido());
    dto.setEmpleadoId(ventas.getEmpleados().getEmpleadoId());
    dto.setNombreEmpleado(ventas.getEmpleados().getNombreEmpleado());
    dto.setTipoEmpleado(ventas.getEmpleados().getTipoEmpleado());
    dto.setComision(ventas.getComisionPorVenta());
    dto.setFecha(ventas.getFecha());

    return dto;
  }


  public List<VentasResponseDTO> obtenerTodasLasVentas() {
    return ventasRepository.findAll().stream()
            .map(this::mapToEntity).toList();
  }

  @Transactional
  public VentasResponseDTO registrarVentas(VentasRequestDTO dto) {

    System.out.printf("Empleado ID recibido: " + dto.getEmpleadoId());
    System.out.printf("Producto ID recibido: " + dto.getProductoId());

    Empleados empleados = empleadosRepository.findById(dto.getEmpleadoId()).
            orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

    Productos productos = productosRepository.findById(dto.getProductoId()).
            orElseThrow(()-> new RuntimeException("Producto no encontrado"));

    if(productos.getStock() < dto.getCantidad()){
      throw new IllegalStateException("No hay suficiente stock disponible");
    }

    //Calcular datos
    double precioUnitario = productos.getPrecioVenta();
    long cantidad = dto.getCantidad();
    double total = precioUnitario * cantidad;
    double comision = calcularComision(empleados, total);

    //Actualizar stock y sueldo
    productos.setStock(productos.getStock()-cantidad);
    productosRepository.save(productos);

//    sueldosMensuales.setComisionesPorVentas(sueldosMensuales.getComisionesPorVentas() + comision);
//    sueldosMensualesServices.calcularSueldoFinal(empleados.getEmpleadoId(), sueldosMensuales.getSueldoId());

    sueldosMensualesServices.actualizarSueldoConVenta(empleados.getEmpleadoId(), comision);

    //actualizar tabla ganancias


    //Guardar venta
    Ventas nuevaVenta = new Ventas(productos, empleados, cantidad, precioUnitario, comision);

    Ventas ventaGuardada = ventasRepository.save(nuevaVenta);

    empleados.setTotalVentas(ventaGuardada);

    gananciaServices.registrarGananciasDeVentas(ventaGuardada);//esta linea

    //Devolver DTO
    return new VentasResponseDTO(
            nuevaVenta.getVentaId(),
            nuevaVenta.getProductos().getProductoId(),
            nuevaVenta.getProductos().getNombreProducto(),
            nuevaVenta.getEmpleados().getEmpleadoId(),
            nuevaVenta.getEmpleados().getTipoEmpleado(),
            nuevaVenta.getEmpleados().getNombreEmpleado(),
            nuevaVenta.getPrecioUnitarioPorVenta(),
            nuevaVenta.getCantidadProductoVendido(),
            nuevaVenta.getPrecioTotal(),
            nuevaVenta.getComisionPorVenta(),
            nuevaVenta.getFecha()
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

    double nuevoPrecioUnitario = productos.getPrecioCosto();
    double nuevoTotal = nuevoPrecioUnitario * nuevaCantidad;
    double nuevaComision = calcularComision(empleados, nuevoTotal);

    productos.setStock(productos.getStock() - nuevaCantidad);

//    sueldosMensuales.setComisionesPorVentas(sueldosMensuales.getComisionesPorVentas() + nuevaComision);
//    sueldosMensualesServices.calcularSueldoFinal(empleados.getEmpleadoId(), sueldosMensuales.getSueldoId());

    sueldosMensualesServices.actualizarSueldoConVenta(empleados.getEmpleadoId(), nuevaComision);

    //actualizar datos

    ventaExistente.setEmpleados(empleados);
    ventaExistente.setProductos(productos);
    ventaExistente.setCantidadProductoVendido(nuevaCantidad);
    ventaExistente.setPrecioUnitarioPorVenta(nuevoPrecioUnitario);
    ventaExistente.setComisionPorVenta(nuevaComision);

    ventasRepository.save(ventaExistente);

    return new VentasResponseDTO(
            ventaExistente.getVentaId(),
            ventaExistente.getProductos().getProductoId(),
            ventaExistente.getProductos().getNombreProducto(),
            ventaExistente.getEmpleados().getEmpleadoId(),
            ventaExistente.getEmpleados().getTipoEmpleado(),
            ventaExistente.getEmpleados().getNombreEmpleado(),
            ventaExistente.getPrecioUnitarioPorVenta(),
            ventaExistente.getCantidadProductoVendido(),
            ventaExistente.getPrecioTotal(),
            ventaExistente.getComisionPorVenta(),
            ventaExistente.getFecha()
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