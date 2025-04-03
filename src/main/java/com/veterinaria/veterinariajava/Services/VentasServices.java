package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

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

  public List<Ventas> obtenerTodasLasVentas() {
    return ventasRepository.findAll();
  }

  public Ventas registrarVentas(Integer productoId, Integer empleadoId, Long cantidadProductoVendido) {
    Empleados empleados = obtenerEmpleado(empleadoId);
    Productos productos = obtenerProducto(productoId);

    validadStockDisponible(productos, cantidadProductoVendido);

    Ventas nuevaVenta = crearVenta(productos, empleados, cantidadProductoVendido);
    ventasRepository.save(nuevaVenta);

    actualizarStock(productos, cantidadProductoVendido);
    actualizarComision(empleados, nuevaVenta.getComisionPorVenta());
    return nuevaVenta;

  }

  private void actualizarComision(Empleados empleados, double comisionPorVenta) {
    empleados.setComisiones(empleados.getComisionesTotal() + comisionPorVenta);
    empleados.setSueldoTotal(empleados.getSueldoPorHora() * empleados.getHorasTrabajadas());
    empleados.setSueldoFinal(empleados.getSueldoTotal() + empleados.getComisionesTotal());
    empleadosRepository.save(empleados);
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

  private Ventas crearVenta(Productos productos, Empleados empleados, Long cantidadProductoVendido) {
    return new Ventas(productos,empleados,cantidadProductoVendido, cantidadProductoVendido);
  }

  private void validadStockDisponible(Productos productos, Long cantidadProductoVendido) {
    if(productos.getStock() < cantidadProductoVendido){
      throw new IllegalStateException("NO hay suficiente Stock disponible");
    }
  }

}