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

//    @Autowired
//    final private SueldosMensuales sueldosMensuales;

    private static final Logger log = LoggerFactory.getLogger(EmpleadosServices.class);
    @Autowired
    final private EmpleadosRepository empleadosRepository;

    private Empleados mapToEntity(EmpleadosRequestDTO dto){
        Empleados empleados = new Empleados();
        empleados.setNombreEmpleado(dto.getNombreEmpleado());
        empleados.setTipoEmpleado(dto.getTipoEmpleado());

        double horasTrabajadas = dto.getHorasTrabajadas();
        double sueldoPorHora = dto.getSueldoPorHora();
        double sueldoTotal = horasTrabajadas * sueldoPorHora;

        empleados.setHorasTrabajadas(dto.getHorasTrabajadas());
        empleados.setSueldoPorHora(dto.getSueldoPorHora());
        // sueldosMensuales.setSueldoTotal(dto.getSueldoPorHora() * dto.getHorasTrabajadas());
        return empleados;
    }

    private EmpleadosResponseDTO mapToDTO(Empleados empleados){
        EmpleadosResponseDTO dto = new EmpleadosResponseDTO();
        dto.setEmpleadoId(empleados.getEmpleadoId());
        dto.setNombreEmpleado(empleados.getNombreEmpleado());
        dto.setTipoEmpleado(empleados.getTipoEmpleado());
//        dto.setSueldoTotal(sueldosMensuales.getSueldoTotal());
//        dto.setComisionesPorVenta(sueldosMensuales.getComisionesPorVentas());
//        dto.setComisionesPorServicios(sueldosMensuales.getComisionPorServicio());
//        dto.setSueldoFinal(sueldosMensuales.getSueldoFinal());
        dto.setTotalVentas(empleadosRepository.cantidadDeVentas(empleados.getEmpleadoId()));
        dto.setTotalServicios(empleadosRepository.cantidadDeServicios(empleados.getEmpleadoId()));
        return dto;

        //Agregar una nueva linea para la columna total ventas
    }

    public EmpleadosServices(SueldosMensuales sueldosMensuales, EmpleadosRepository empleadosRepository) {
        //this.sueldosMensuales = sueldosMensuales;
        this.empleadosRepository = empleadosRepository;
    }

    public List<EmpleadosResponseDTO>obtenerTodos(){
        return empleadosRepository.findAll().stream()
                .map(this::mapToDTO).toList();
    }

    public Optional<EmpleadosResponseDTO>obtenerPorId(Integer id){
        return empleadosRepository.findById(id)
                .map(this::mapToDTO);
    }

    public EmpleadosResponseDTO guardarEmpleados(EmpleadosRequestDTO dto){
        Empleados empleados = mapToEntity(dto);
        Empleados guardado = empleadosRepository.save(empleados);
        return mapToDTO(guardado);
    }

    public void eliminarEmpleado(Integer id){
        empleadosRepository.deleteById(id);
    }

//    public void calcularSueldoFinal(Integer empleadoId){
//        Empleados empleados = empleadosRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
//
//        double sueldoFinal = sueldosMensuales.getSueldoTotal() + sueldosMensuales.getComisionesPorVentas() + sueldosMensuales.getComisionPorServicio();
//        sueldosMensuales.setSueldoFinal(sueldoFinal);
//
//        empleadosRepository.save(empleados);
//
//    }

    public EmpleadosResponseDTO actualizarEmpleado(Integer id, EmpleadosRequestDTO dto){
        Empleados empleadoExistente = empleadosRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        empleadoExistente.setNombreEmpleado(dto.getNombreEmpleado());
        empleadoExistente.setTipoEmpleado(dto.getTipoEmpleado());
//        empleadoExistente.setHorasTrabajadas(dto.getHorasTrabajadas());
//        empleadoExistente.setSueldoPorHora(dto.getSueldoPorHora());
//        empleadoExistente.setSueldoTotal(dto.getSueldoPorHora() * dto.getHorasTrabajadas());

        empleadosRepository.save(empleadoExistente);
        return mapToDTO(empleadoExistente);
    }
}
