package com.veterinaria.veterinariajava.Services;
import com.veterinaria.veterinariajava.DTO.SueldosMensualesResponseDTO;
import com.veterinaria.veterinariajava.Repository.*;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.RegistroSalarialMensual;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import com.veterinaria.veterinariajava.Tables.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SueldosMensualesServices {

    @Autowired
    private SueldosMensualesRepository sueldosMensualesRepository;

    @Autowired
    private VentasRepository ventasRepository;

    private EmpleadosServices empleadosServices;

    @Autowired
    private GastosFijosServices gastosFijosServices;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private RegistroSalarialMensualRepository registroSalarialMensualRepository;

    @Autowired
    private GastosFijosRepository gastosFijosRepository;

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
        dto.setFecha(LocalDateTime.now());

        return dto;
    }

    public List<SueldosMensualesResponseDTO> obtenerTodas(){
        return sueldosMensualesRepository.findAll().stream()
                .map(this::mapToEntity).toList();
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

    private double comisionTipoEmpleado(Empleados empleados, double total){

        if(empleados.getTipoEmpleado().equalsIgnoreCase("Veterinario")){
            return total * 0.15;
        }
        else if (empleados.getTipoEmpleado().equalsIgnoreCase("Recepcionista")){
            return total * 0.10;
        }

        return total;
    }


    public List<SueldosMensualesResponseDTO> generarSueldoDelMes(int month, int year){

        List<Empleados> empleados = empleadosRepository.findAll();
        if(empleados.isEmpty()){
            System.out.println("No hay empleados para registrar sueldos");
            return Collections.emptyList();
        }

        List<SueldosMensualesResponseDTO> responseDTOS = new ArrayList<>();
        double totalSueldos = 0.0;

        for (Empleados e : empleados){
            List<SueldosMensuales> sueldosMensuales =
                    sueldosMensualesRepository.findByEmpleadoAndYearAndMonthNative(e.getEmpleadoId(), year, month);

            for(SueldosMensuales sMensuales : sueldosMensuales){

                double sueldoFinal = sMensuales.getSueldoFinal();
                double sueldoBase = sMensuales.getSueldoTotal();
                double comisionVentas = sMensuales.getComisionesPorVentas();
                double comisionServicios = sMensuales.getComisionPorServicio();

                //crear registro historico
                RegistroSalarialMensual registro = new RegistroSalarialMensual();
                registro.setEmpleadoHistoricoId(e.getEmpleadoId());
                registro.setMonth(month);
                registro.setYear(year);
                registro.setSueldoBase(sueldoBase);
                registro.setComisionServicios(comisionServicios);
                registro.setComisionVentas(comisionVentas);
                registro.setSueldoFinal(sueldoFinal);
                registro.setFechaGeneracion(LocalDate.now());

                registroSalarialMensualRepository.save(registro);

                //mapear a dto
                SueldosMensualesResponseDTO dto = new SueldosMensualesResponseDTO();
                dto.setEmpleadoId(e.getEmpleadoId());
                dto.setNombreEmpleado(e.getNombreEmpleado());
                dto.setFecha(LocalDateTime.now());
                dto.setSueldoTotal(sueldoBase);
                dto.setComisionPorVenta(comisionVentas);
                dto.setComisionPorServicio(comisionServicios);
                dto.setSueldoFinal(sueldoFinal);
                dto.setFecha(LocalDateTime.now());


                responseDTOS.add(dto);

                totalSueldos += dto.getSueldoFinal();
                System.out.println("El total de los sueldos es de: " + totalSueldos);

            }
        }

        gastosFijosServices.registrarGastoFijoPorSueldo(totalSueldos, year, month);

        return responseDTOS;

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
