package com.veterinaria.veterinariajava.Controllers;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/{id}")
    public ResponseEntity<Servicios> actualizarServicio(@PathVariable Integer id, @RequestBody Servicios servicioActualizado){
        try {
            Servicios servicios = serviciosServices.actualizarServicio(id, servicioActualizado);
            return ResponseEntity.ok(servicios);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
