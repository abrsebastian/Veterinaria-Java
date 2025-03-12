package com.veterinaria.veterinariajava.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.veterinaria.veterinariajava.Services.ProductosServices;
import com.veterinaria.veterinariajava.Tables.Productos;

@RestController
@RequestMapping("/productos")

public class ProductosController {

    @Autowired
    private ProductosServices productosServices;

    public List<Productos> listaProductos(){
        return productosServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Productos> obtenerProducto(@PathVariable Integer id){
        return productosServices.obtenerPorId(id);
    }

    @PostMapping("path")
    public Productos crearGanancia(@RequestBody Productos productos) {
        return productosServices.guardarProductos(productos);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productosServices.eliminarProducto(id);
    }

}
