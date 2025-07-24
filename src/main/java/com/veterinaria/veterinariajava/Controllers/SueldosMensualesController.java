package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
import com.veterinaria.veterinariajava.Services.SueldosMensualesServices;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sueldos_mensuales")

public class SueldosMensualesController {
    @Autowired
    private SueldosMensualesServices sueldosMensualesServices;

    @GetMapping
    public List<SueldosMensuales> listaSueldos(){
        return sueldosMensualesServices.obtenerTodas();
    }

    @GetMapping("/buscar/{id}")
    public Optional<SueldosMensuales> obtenerSueldo(@PathVariable Integer id){
        return sueldosMensualesServices.obtenerPorId(id);
    }

    @PostMapping("/{generar}")
    public List<SueldosMensualesResponseDTO> resumenSueldosMensuales(@RequestParam int year, @RequestParam int month){
        return sueldosMensualesServices.generarSueldoDelMes(year, month);
    }

//    @PostMapping
//    public ResponseEntity<SueldosMensualesResponseDTO> crearSueldo(@RequestBody SueldosMensuales sueldosMensuales){
//        sueldosMensualesServices.guardarSueldoBase(sueldosMensuales)
//    }

    @DeleteMapping("/{id}")
    public void eliminarSueldo(@PathVariable Integer id){
        sueldosMensualesServices.eliminarSueldo(id);
    }
}
