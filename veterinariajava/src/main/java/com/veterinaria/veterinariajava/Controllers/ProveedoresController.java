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
import com.veterinaria.veterinariajava.Services.ProveedoresServices;
import com.veterinaria.veterinariajava.Tables.Proveedores;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresServices proveedoresServices;

    public List<Proveedores> listaProductos(){
        return proveedoresServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Proveedores> obtenerProveedor(@PathVariable Integer id){
        return proveedoresServices.obtenerPorId(id);
    }

    @PostMapping("path")
    public Proveedores crearProveedor(@RequestBody Proveedores proveedores) {
        return proveedoresServices.guardaProveedores(proveedores);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id){
        proveedoresServices.eliminarProveedor(id);
    }
}
