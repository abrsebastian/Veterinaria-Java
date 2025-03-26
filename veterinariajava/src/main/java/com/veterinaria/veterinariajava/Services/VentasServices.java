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

    public List<Ventas>obtenerTodasLasVentas(){
      return ventasRepository.findAll();
    } 

    public Ventas ventasRegistradas(Integer productoId,Integer empleadoId, int cantidad){
      Optional <Empleados> empleadosOptional = empleadosRepository.findById(empleadoId);
      Optional <Productos> productosOptional = productosRepository.findById(productoId);

      if(productosOptional.isPresent() && empleadosOptional.isPresent()){

        Productos productos = productosOptional.get();
        Empleados empleados = empleadosOptional.get();

        Ventas nuevaVenta = new Ventas(productos, empleados, null, cantidad);
        ventasRepository.save(nuevaVenta);

        double calcularComision = empleados.getSueldoFinal() + nuevaVenta.getComisionPorVenta();
        empleados.setSueldoFinal(calcularComision);
        empleadosRepository.save(empleados);

        return nuevaVenta;

      }
      throw new RuntimeErrorException(null, "Producto o Empleado no encontrado");
      
    }
}