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


import com.veterinaria.veterinariajava.Services.ServiciosServices;

import com.veterinaria.veterinariajava.Tables.Servicios;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosServices serviciosServices;
   
    @GetMapping
    public List<Servicios> listaServicios(){
        return serviciosServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Servicios> obtenerServicio(@PathVariable Integer id){
        return serviciosServices.obtenerPorId(id);
    }

    @PostMapping
    public Servicios crearServicio(@RequestBody Servicios servicios) {
        return serviciosServices.guardarServicio(servicios);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Integer id){
        serviciosServices.eliminarServicio(id);
    }

}
