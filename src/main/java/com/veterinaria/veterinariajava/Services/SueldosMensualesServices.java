package com.veterinaria.veterinariajava.Services;
import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Repository.SueldosMensualesRepository;
import com.veterinaria.veterinariajava.Repository.VentasRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import com.veterinaria.veterinariajava.Tables.Ventas;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SueldosMensualesServices {

    @Autowired
    private SueldosMensualesRepository sueldosMensualesRepository;

    @Autowired
    private VentasRepository ventasRepository;

    private EmpleadosServices empleadosServices;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    @Lazy
    public void setEmpleadosServices(EmpleadosServices empleadosServices){
        this.empleadosServices=empleadosServices;
    }

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

        LocalDate now = LocalDate.now();
        sueldosMensuales.setYear(now.getYear());
        sueldosMensuales.setMonth(now.getMonthValue());

        double sueldoTotal = empleados.getSueldoPorHora() * empleados.getHorasTrabajadas();
        sueldosMensuales.setSueldoTotal(sueldoTotal);

        sueldosMensuales.setComisionesPorVentas(0.0);
        sueldosMensuales.setComisionPorServicio(0.0);
        sueldosMensuales.setSueldoFinal(sueldoTotal);

        return sueldosMensualesRepository.save(sueldosMensuales);

    }

    public void eliminarSueldo(Integer id){
        sueldosMensualesRepository.deleteById(id);
    }

    public SueldosMensuales actualizarSueldoConServicio(Integer empleadoId, double comisionServicio){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        List<SueldosMensuales> resultados = sueldosMensualesRepository.
                findByEmpleadoAndYearAndMonthNative(empleadoId, year, month);

        SueldosMensuales sueldosMensuales;

        if(resultados.isEmpty()){

            Empleados empleados = empleadosRepository.findById(empleadoId).
                    orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

            sueldosMensuales = new SueldosMensuales();
            sueldosMensuales.setEmpleados(empleados);
            sueldosMensuales.setYear(year);
            sueldosMensuales.setMonth(month);
            sueldosMensuales.setSueldoTotal(empleados.getSueldoPorHora() * empleados.getHorasTrabajadas());
            sueldosMensuales.setComisionPorServicio(0.0);
            sueldosMensuales.setComisionesPorVentas(0.0);
            sueldosMensuales.setSueldoFinal(sueldosMensuales.getSueldoTotal());
        }
        else {
            sueldosMensuales = resultados.get(0);

            double nuevaComisionPorServicio = sueldosMensuales.getComisionPorServicio() + comisionServicio;
            sueldosMensuales.setComisionPorServicio(nuevaComisionPorServicio);

            double sueldoFinal = sueldosMensuales.getSueldoTotal()
                    + sueldosMensuales.getComisionPorServicio()
                    + sueldosMensuales.getComisionesPorVentas();
            sueldosMensuales.setSueldoFinal(sueldoFinal);
        }

        return sueldosMensualesRepository.save(sueldosMensuales);
    }

    public SueldosMensuales actualizarSueldoConVenta(Integer empleadoId, double comisionVenta){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        List<SueldosMensuales> resultados = sueldosMensualesRepository.
                findByEmpleadoAndYearAndMonthNative(empleadoId, year, month);

        SueldosMensuales sueldosMensuales;

        if(resultados.isEmpty()){

            Empleados empleados = empleadosRepository.findById(empleadoId).
                    orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

            sueldosMensuales = new SueldosMensuales();
            sueldosMensuales.setEmpleados(empleados);
            sueldosMensuales.setYear(year);
            sueldosMensuales.setMonth(month);
            sueldosMensuales.setSueldoTotal(empleados.getSueldoPorHora() * empleados.getHorasTrabajadas());
            sueldosMensuales.setComisionPorServicio(0.0);
            sueldosMensuales.setComisionesPorVentas(0.0);
            sueldosMensuales.setSueldoFinal(sueldosMensuales.getSueldoTotal());
        }
        else {
            sueldosMensuales = resultados.get(0);
        }

        double nuevaComisionPorVenta = sueldosMensuales.getComisionesPorVentas() + comisionVenta;
        sueldosMensuales.setComisionesPorVentas(nuevaComisionPorVenta);

        double sueldoFinal = sueldosMensuales.getSueldoTotal()
                + sueldosMensuales.getComisionesPorVentas()
                + sueldosMensuales.getComisionPorServicio();
        sueldosMensuales.setSueldoFinal(sueldoFinal);

        return sueldosMensualesRepository.save(sueldosMensuales);
    }

    private double calcularComisionPorVenta(Integer empleadoId, int month, int year){

        Empleados empleados = empleadosRepository.findById(empleadoId).
                orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        List<Ventas> ventas = ventasRepository.findEmpleadoIdAndFecha(year, month, empleadoId);

        double nuevoTotal = 0;

        for(Ventas v : ventas){
            nuevoTotal += v.getPrecioTotal();
        }

        return comisionTipoEmpleado(empleados, nuevoTotal);

    }

//    private double calcularComisionPorServicio(Integer empleadoId, int month, int year){
//
//    }

    private double comisionTipoEmpleado(Empleados empleados, double total){

        if(empleados.getTipoEmpleado().equalsIgnoreCase("Veterinario")){
            return total * 0.15;
        }
        else if (empleados.getTipoEmpleado().equalsIgnoreCase("Recepcionista")){
            return total * 0.10;
        }

        return total;
    }

    public List<SueldosMensualesResponseDTO> generarSueldoDelMes(Integer empleados_id, int year, int  month){
        List<Empleados> empleados = empleadosRepository.findAll();
        List<SueldosMensualesResponseDTO> responseDTOS = new ArrayList<>();

        for (Empleados e : empleados){
            Integer empleadoId = e.getEmpleadoId();

            Optional<SueldosMensuales> sueldoExistente = sueldosMensualesRepository.findByEmpleadoAndYearAndMonthNative(empleados_id, year, month);
        }
        return  responseDTOS;
    }

    public List<SueldosMensualesResponseDTO>obtenerSueldoDelMes(int year, int month){
        List<SueldosMensuales> sueldosMensuales = sueldosMensualesRepository.obtenerListaSueldos(year, month);
        List<SueldosMensualesResponseDTO> responseDTOS = new ArrayList<>();

        for(SueldosMensuales s : sueldosMensuales){
            responseDTOS.add(mapToEntity(s));
        }

        return responseDTOS;
    }
}
