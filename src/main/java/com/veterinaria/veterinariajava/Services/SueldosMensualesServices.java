package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Repository.SueldosMensualesRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        //continuar con el mapToentity para crear el service de crear sueldo

    private SueldosMensualesResponseDTO mapToEntity(SueldosMensuales sueldosMensuales){

        SueldosMensualesResponseDTO dto = new SueldosMensualesResponseDTO();
        dto.setEmpleadoId(sueldosMensuales.getEmpleados().getEmpleadoId());
        dto.setNombreEmpleado(sueldosMensuales.getEmpleados().getNombreEmpleado());
        dto.setSueldoTotal(sueldosMensuales.getSueldoTotal());
        dto.setComisionPorServicio(sueldosMensuales.getComisionPorServicio());
        dto.setComisionPorVenta(sueldosMensuales.getComisionesPorVentas());
        dto.setSueldoFinal(sueldosMensuales.getSueldoFinal());

        return dto;
    }

    public List<SueldosMensuales> obtenerTodas(){
        return sueldosMensualesRepository.findAll();
    }

    public Optional<SueldosMensuales> obtenerPorId(Integer id){
        return sueldosMensualesRepository.findById(id);
    }

    public SueldosMensuales guardarSueldoBase(Integer empleadoId){

        Empleados empleados = empleadosRepository.findById(empleadoId).
                orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        SueldosMensuales sueldosMensuales = new SueldosMensuales();

        sueldosMensuales.setEmpleados(empleados);

        double sueldoTotal = empleados.getSueldoPorHora() * empleados.getHorasTrabajadas();
        sueldosMensuales.setSueldoTotal(sueldoTotal);

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

    public List<SueldosMensualesResponseDTO> generarSueldoDelMes(int year, int  month){
        List<Empleados> empleados = empleadosRepository.findAll();
        List<SueldosMensualesResponseDTO> responseDTOS = new ArrayList<>();

        for (Empleados e : empleados){
            SueldosMensuales sueldo = new SueldosMensuales();

            sueldo.setEmpleados(e);
            sueldo.setYear(year);
            sueldo.setMonth(month);
            sueldo.setSueldoTotal(e.getSueldoPorHora() * e.getHorasTrabajadas());
            sueldo.setComisionPorServicio();


        }

    }

}





































