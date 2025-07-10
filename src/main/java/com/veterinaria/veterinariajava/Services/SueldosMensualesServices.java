package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.Repository.CategoriasRepository;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Repository.SueldosMensualesRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SueldosMensualesServices {

    @Autowired
    private SueldosMensualesRepository sueldosMensualesRepository;

    @Autowired
    private EmpleadosServices empleadosServices;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    public List<SueldosMensuales> obtenerTodas(){
        return sueldosMensualesRepository.findAll();
    }

    public Optional<SueldosMensuales> obtenerPorId(Integer id){
        return sueldosMensualesRepository.findById(id);
    }

    public SueldosMensuales guardarSueldo(SueldosMensuales sueldosMensuales){
        return sueldosMensualesRepository.save(sueldosMensuales);
    }

    public void eliminarSueldo(Integer id){
        sueldosMensualesRepository.deleteById(id);
    }

    public void calcularSueldoFinal(Integer empleadoId, Integer sueldoId){
        Empleados empleados = empleadosRepository.findById(empleadoId).
                orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        SueldosMensuales sueldosMensuales = sueldosMensualesRepository.findById(sueldoId).
                orElseThrow(() -> new RuntimeException("Sueldo no encontrado"));

        double sueldoFinal = sueldosMensuales.getSueldoTotal()
                + sueldosMensuales.getComisionesPorVentas()
                + sueldosMensuales.getComisionPorServicio();

        sueldosMensuales.setSueldoFinal(sueldoFinal);

        sueldosMensualesRepository.save(sueldosMensuales);

    }

}
