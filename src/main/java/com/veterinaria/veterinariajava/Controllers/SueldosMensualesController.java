package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
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
    public List<SueldosMensualesResponseDTO> listaSueldos(){
        return sueldosMensualesServices.obtenerTodas();
    }

    @GetMapping("/buscar/{id}")
    public Optional<SueldosMensuales> obtenerSueldo(@PathVariable Integer id){
        return sueldosMensualesServices.obtenerPorId(id);
    }

    @PostMapping("/generar") ///generar?year=2025&month=7
    public List<SueldosMensualesResponseDTO> resumenSueldosMensuales(@RequestParam int year, @RequestParam int month){
        return sueldosMensualesServices.generarSueldoDelMes(month, year);
    }

    @GetMapping("/listar") ///listar?year=2025&month=7
    public List<SueldosMensualesResponseDTO> listMonthAndYear(@RequestParam int month, @RequestParam int year){
        return sueldosMensualesServices.obtenerSueldoDelMes(month, year);
    }

    @DeleteMapping("/{id}")
    public void eliminarSueldo(@PathVariable Integer id){
        sueldosMensualesServices.eliminarSueldo(id);
    }
}
