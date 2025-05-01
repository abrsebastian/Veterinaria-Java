package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.Repository.CategoriasRepository;
import com.veterinaria.veterinariajava.Repository.ProveedoresRepository;
import com.veterinaria.veterinariajava.Tables.Categorias;
import com.veterinaria.veterinariajava.Tables.Proveedores;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.veterinaria.veterinariajava.Repository.ProductosRepository;

import com.veterinaria.veterinariajava.Tables.Productos;

@Service
public class ProductosServices {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Productos>obtenerTodos(){
        return productosRepository.findAll();
    }

    public Optional<Productos>obtenerPorId(Integer id){
        return productosRepository.findById(id);
    }

    //Bloque de codigo responsable de que productos anide las tablas proveedores y categorias

    public Productos guardarProductos(Productos productos){
//        Categorias categorias = categoriasRepository.findById(productos.getCategoria().getCategoria_id()).
//                orElseThrow(()-> new EntityNotFoundException("Categoría no encontrada"));
        Proveedores proveedores = proveedoresRepository.findById(productos.getProveedor().getProveedorId()).
                orElseThrow(()-> new EntityNotFoundException("Proveedor no encontrado"));

        //productos.setCategoria(categorias);
        productos.setProveedor(proveedores);

        return productosRepository.save(productos);
    }

    public Productos actualizarProducto(Integer id, Productos productoActualizado){
        Productos productoExistente = productosRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado"));

        productoExistente.setNombreProducto(productoActualizado.getNombreProducto());
        productoExistente.setStock(productoActualizado.getStock());
        // productos.setProveedor(productoActualizado.getProveedor());
        productoExistente.setPrecioUnitario(productoActualizado.getPrecioUnitario());
        // productos.setCategoria(productoActualizado.getCategoria());

        //Integer categoriaId = productoActualizado.getCategoria().getCategoria_id();
        Integer proveedorId = productoActualizado.getProveedor().getProveedorId();

        //Categorias categorias = categoriasRepository.findById(categoriaId).
        //      orElseThrow(()-> new RuntimeException("Categoría no encontrada"));
        Proveedores proveedores = proveedoresRepository.findById(proveedorId).
                orElseThrow(()-> new RuntimeException("Proveedor no encontrado"));

        //productoExistente.setCategoria(categorias);
        productoExistente.setProveedor(proveedores);

        return productosRepository.save(productoExistente);
    }

    public void eliminarProducto(Integer id){
        productosRepository.deleteById(id);
    }

}
