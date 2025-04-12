package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

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
  public Ventas registrarVentas(Integer productoId, Integer empleadoId, Long cantidadProductoVendido) {
    Empleados empleados = obtenerEmpleado(empleadoId);
    Productos productos = obtenerProducto(productoId);

    validarStockDisponible(productos, cantidadProductoVendido);

    actualizarStock(productos, cantidadProductoVendido);

    double comision = calcularComision(empleados, productos, cantidadProductoVendido);
    actualizarComision(empleados, comision);
    empleadosService.calcularSueldoFinal(empleadoId);

    Ventas nuevaVenta = new Ventas(productos, empleados, cantidadProductoVendido, productos.getPrecioUnitario(), comision);
    ventasRepository.save(nuevaVenta);

    actualizarStock(productos, cantidadProductoVendido);

    return nuevaVenta;

  }

  

  private void actualizarComision(Empleados empleados, double comisionPorVenta) {
    empleados.setComisionesTotal(empleados.getComisionesTotal() + comisionPorVenta);
    empleados.setSueldoTotal(empleados.getSueldoPorHora() * empleados.getHorasTrabajadas());

  }

  private void actualizarStock(Productos productos, Long cantidadProductoVendido) {
    productos.setStock(productos.getStock() - cantidadProductoVendido);
  }

  private Empleados obtenerEmpleado(Integer empleadoId) {
    return empleadosRepository.findById(empleadoId).orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
  }

  private Productos obtenerProducto(Integer productoId) {
    return productosRepository.findById(productoId).orElseThrow(()-> new RuntimeException("Producto no encontrado"));
  }

//  private Ventas crearVenta(Productos productos, Empleados empleados, Long cantidadProductoVendido) {
//    return new Ventas(productos,empleados,cantidadProductoVendido, cantidadProductoVendido);
//  }

  private void validarStockDisponible(Productos productos, Long cantidadProductoVendido) {
    if(productos.getStock() < cantidadProductoVendido){
      throw new IllegalStateException("NO hay suficiente Stock disponible");
    }
  }

  private double calcularComision(Empleados empleados, Productos productos, Long cantidad){
    double total = productos.getPrecioUnitario() * cantidad;
    if("Veterinario".equalsIgnoreCase(empleados.getTipoEmpleado())){
      return total * 0.15;
    }
    else if("Recepcionista".equalsIgnoreCase(empleados.getTipoEmpleado())){
      return total * 0.10;
    }
    return 0.0;
  }

}