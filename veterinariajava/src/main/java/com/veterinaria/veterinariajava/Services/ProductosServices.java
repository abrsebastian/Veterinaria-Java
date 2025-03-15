package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.GananciasRepository;
import com.veterinaria.veterinariajava.Repository.ProductosRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;
import com.veterinaria.veterinariajava.Tables.Productos;

@Service
public class ProductosServices {
    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos>obtenerTodos(){
        return productosRepository.findAll();
    }

     public Optional<Productos>obtenerPorId(Integer id){
        return productosRepository.findById(id);
    }

    public Productos guardarProductos(Productos productos){
        return productosRepository.save(productos);
    }

    public void eliminarProducto(Integer id){
        productosRepository.deleteById(id);
    }
}
