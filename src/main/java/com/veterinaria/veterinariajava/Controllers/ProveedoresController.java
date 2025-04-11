package com.veterinaria.veterinariajava.Controllers;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinariajava.Services.ProveedoresServices;
import com.veterinaria.veterinariajava.Tables.Proveedores;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresServices proveedoresServices;

    @GetMapping
    public List<Proveedores> listaProductos(){
        return proveedoresServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Proveedores> obtenerProveedor(@PathVariable Integer id){
        return proveedoresServices.obtenerPorId(id);
    }

    @PostMapping
    public Proveedores crearProveedor(@RequestBody Proveedores proveedores) {
        return proveedoresServices.guardaProveedores(proveedores);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id){
        proveedoresServices.eliminarProveedor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedores proveedorActualizado) {
        try {
            Proveedores actualizado = proveedoresServices.actualizarProveedor(id, proveedorActualizado);
            ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

}
