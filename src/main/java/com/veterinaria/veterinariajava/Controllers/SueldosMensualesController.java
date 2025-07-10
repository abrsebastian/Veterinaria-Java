package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.Services.SueldosMensualesServices;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sueldos_mensuales")

public class SueldosMensualesController {
    @Autowired
    private SueldosMensualesServices sueldosMensualesServices;

    @GetMapping
    public List<SueldosMensuales> listarCategorias(){
        return sueldosMensualesServices.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<SueldosMensuales> obtenerCategorria(@PathVariable Integer id){
        return sueldosMensualesServices.obtenerPorId(id);
    }

    @PostMapping
    public SueldosMensuales crearCategoria(@RequestBody SueldosMensuales sueldosMensuales) {
        return sueldosMensualesServices.guardarSueldo(sueldosMensuales);
    }

    @DeleteMapping("/{id}")
    public void eliminarSueldo(@PathVariable Integer id){
        sueldosMensualesServices.eliminarSueldo(id);
    }
}
