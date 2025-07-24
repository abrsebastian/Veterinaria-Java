package com.veterinaria.veterinariajava.Services;
import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Repository.SueldosMensualesRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
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

        SueldosMensuales sueldosMensuales = sueldosMensualesRepository.findByEmpleadoAndYearAndMonthNative(year, month).
                orElseGet(()-> {
                    //Si no existe, crear nuevo
                    SueldosMensuales nuevoSueldo = new SueldosMensuales();

                    Empleados empleados = empleadosRepository.findById(empleadoId)
                            .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
                    nuevoSueldo.setEmpleados(empleados);
                    nuevoSueldo.setYear(year);
                    nuevoSueldo.setMonth(month);
                    double sueldoBase = empleados.getSueldoPorHora() * empleados.getHorasTrabajadas();
                    nuevoSueldo.setSueldoTotal(sueldoBase);
                    nuevoSueldo.setComisionPorServicio(0.0);
                    nuevoSueldo.setComisionesPorVentas(0.0);
                    nuevoSueldo.setSueldoFinal(sueldoBase);

                    return nuevoSueldo;
                });

        double nuevaComisionPorServicio = sueldosMensuales.getComisionPorServicio() + comisionServicio;
        sueldosMensuales.setComisionPorServicio(nuevaComisionPorServicio);

        double sueldoFinal = sueldosMensuales.getSueldoTotal()
                + sueldosMensuales.getComisionPorServicio()
                + sueldosMensuales.getComisionesPorVentas();
        sueldosMensuales.setSueldoFinal(sueldoFinal);

        return sueldosMensualesRepository.save(sueldosMensuales);
    }

    public SueldosMensuales actualizarSueldoConVenta(Integer empleadoId, double comisionVenta){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        SueldosMensuales sueldosMensuales = sueldosMensualesRepository.findByEmpleadoAndYearAndMonthNative(year, month).
                orElseGet(()-> {
                    //Si no existe, crear nuevo
                    SueldosMensuales nuevoSueldo = new SueldosMensuales();

                    Empleados empleados = empleadosRepository.findById(empleadoId)
                            .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
                    nuevoSueldo.setEmpleados(empleados);
                    nuevoSueldo.setYear(year);
                    nuevoSueldo.setMonth(month);
                    double sueldoBase = empleados.getSueldoPorHora() * empleados.getHorasTrabajadas();
                    nuevoSueldo.setSueldoTotal(sueldoBase);
                    nuevoSueldo.setComisionPorServicio(0.0);
                    nuevoSueldo.setComisionesPorVentas(0.0);
                    nuevoSueldo.setSueldoFinal(sueldoBase);

                    return nuevoSueldo;
        });

        double nuevaComisionPorVenta = sueldosMensuales.getComisionesPorVentas() + comisionVenta;
        sueldosMensuales.setComisionesPorVentas(nuevaComisionPorVenta);

        double sueldoFinal = sueldosMensuales.getSueldoTotal()
                + sueldosMensuales.getComisionesPorVentas()
                + sueldosMensuales.getComisionPorServicio();
        sueldosMensuales.setSueldoFinal(sueldoFinal);

        return sueldosMensualesRepository.save(sueldosMensuales);
    }

    public List<SueldosMensualesResponseDTO> generarSueldoDelMes(int year, int  month){
        List<Empleados> empleados = empleadosRepository.findAll();
        List<SueldosMensualesResponseDTO> responseDTOS = new ArrayList<>();

        for (Empleados e : empleados){
            SueldosMensuales sueldosMensuales = sueldosMensualesRepository.
                    findByEmpleadoAndYearAndMonthNative(year, month).orElseGet(()->{
                       SueldosMensuales nuevo = new SueldosMensuales();
                       nuevo.setEmpleados(e);
                       nuevo.setYear(year);
                       nuevo.setMonth(month);
                       nuevo.setSueldoTotal(e.getHorasTrabajadas() * e.getSueldoPorHora());
                       return nuevo;
                    });

            double sueldoFinal = sueldosMensuales.getSueldoTotal()
                    + sueldosMensuales.getComisionPorServicio()
                    + sueldosMensuales.getComisionesPorVentas();
            sueldosMensuales.setSueldoFinal(sueldoFinal);

            SueldosMensuales guardado = sueldosMensualesRepository.save(sueldosMensuales);

            SueldosMensualesResponseDTO dto = mapToEntity(guardado);
            responseDTOS.add(dto);
        }
        return  responseDTOS;
    }
}
