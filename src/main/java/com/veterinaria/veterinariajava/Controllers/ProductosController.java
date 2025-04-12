package com.veterinaria.veterinariajava.Controllers;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinariajava.Services.ProductosServices;
import com.veterinaria.veterinariajava.Tables.Productos;

@RestController
@RequestMapping("/productos")

public class ProductosController {

    @Autowired
    private ProductosServices productosServices;

    @GetMapping
    public List<Productos> listaProductos(){
        return productosServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Productos> obtenerProducto(@PathVariable Integer id){
        return productosServices.obtenerPorId(id);
    }

    @PostMapping
    public Productos crearProductos(@RequestBody Productos productos) {
        return productosServices.guardarProductos(productos);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productosServices.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Integer id, @RequestBody Productos productoActualizado){
        try {
            Productos actualizado = productosServices.actualizarProducto(id, productoActualizado);
            return ResponseEntity.ok(actualizado);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
