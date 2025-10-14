package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.EmpleadosRequestDTO;
import com.veterinaria.veterinariajava.DTO.EmpleadosResponseDTO;
import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;

@Service
public class EmpleadosServices {



    private static final Logger log = LoggerFactory.getLogger(EmpleadosServices.class);
    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private SueldosMensualesServices sueldosMensualesServices;

    public List<EmpleadosResponseDTO>obtenerTodos(){
        return empleadosRepository.findAll().stream()
                .map(this::mapToDTO).toList();
    }

    public Optional<EmpleadosResponseDTO>obtenerPorId(Integer id){
        return empleadosRepository.findById(id)
                .map(this::mapToDTO);
    }

    private Empleados mapToEntity(EmpleadosRequestDTO dto){
        Empleados empleados = new Empleados();
        empleados.setNombreEmpleado(dto.getNombreEmpleado());
        empleados.setTipoEmpleado(dto.getTipoEmpleado());

        double horasTrabajadas = dto.getHorasTrabajadas();
        double sueldoPorHora = dto.getSueldoPorHora();
        double sueldoTotal = horasTrabajadas * sueldoPorHora;

        empleados.setHorasTrabajadas(horasTrabajadas);
        empleados.setSueldoPorHora(sueldoPorHora);

        return empleados;
    }

    private EmpleadosResponseDTO mapToDTO(Empleados empleados){
        EmpleadosResponseDTO dto = new EmpleadosResponseDTO();
        dto.setEmpleadoId(empleados.getEmpleadoId());
        dto.setNombreEmpleado(empleados.getNombreEmpleado());
        dto.setTipoEmpleado(empleados.getTipoEmpleado());
        dto.setTotalVentas(empleadosRepository.cantidadDeVentas(empleados.getEmpleadoId()));
        dto.setTotalServicios(empleadosRepository.cantidadDeServicios(empleados.getEmpleadoId()));
        return dto;

        //Agregar una nueva linea para la columna total ventas
    }

    public EmpleadosResponseDTO guardarEmpleados(EmpleadosRequestDTO dto){

        Empleados empleados = mapToEntity(dto);
        Empleados guardado = empleadosRepository.save(empleados);
        sueldosMensualesServices.guardarSueldoBase(empleados.getEmpleadoId());

        return mapToDTO(guardado);
    }

    public EmpleadosResponseDTO actualizarEmpleado(Integer id, EmpleadosRequestDTO dto){
        Empleados empleadoExistente = empleadosRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        empleadoExistente.setTipoEmpleado(dto.getTipoEmpleado());
        empleadoExistente.setNombreEmpleado(dto.getNombreEmpleado());
        empleadoExistente.setHorasTrabajadas(dto.getHorasTrabajadas());
        empleadoExistente.setSueldoPorHora(dto.getSueldoPorHora());

        sueldosMensualesServices.guardarSueldoBase(empleadoExistente.getEmpleadoId());

        empleadosRepository.save(empleadoExistente);
        return mapToDTO(empleadoExistente);
    }

    public void eliminarEmpleado(Integer id){
        empleadosRepository.deleteById(id);
    }

}
