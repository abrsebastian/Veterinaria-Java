package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.EmpleadosRequestDTO;
import com.veterinaria.veterinariajava.DTO.EmpleadosResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;

@Service
public class EmpleadosService {
    private static final Logger log = LoggerFactory.getLogger(EmpleadosService.class);
    @Autowired
    final private EmpleadosRepository empleadosRepository;

    private Empleados mapToEntity(EmpleadosRequestDTO dto){
        Empleados empleados = new Empleados();
        empleados.setNombreEmpleado(dto.getNombreEmpleado());
        empleados.setTipoEmpleado(dto.getTipoEmpleado());
        empleados.setHorasTrabajadas(dto.getHorasTrabajadas());
        empleados.setSueldoPorHora(dto.getSueldoPorHora());
        empleados.setSueldoTotal(dto.getSueldoPorHora() * dto.getHorasTrabajadas());
        return empleados;
    }

    private EmpleadosResponseDTO mapToDTO(Empleados empleados){
        EmpleadosResponseDTO dto = new EmpleadosResponseDTO();
        dto.setEmpleadoId(empleados.getEmpleadoId());
        dto.setNombreEmpleado(empleados.getNombreEmpleado());
        dto.setTipoEmpleado(empleados.getTipoEmpleado());
        dto.setSueldoTotal(empleados.getSueldoTotal());
        dto.setComisionesPorVenta(empleados.getComisionesPorVentas());
        dto.setComisionesPorServicios(empleados.getComisionPorServicio());
        dto.setSueldoFinal(empleados.getSueldoFinal());
        dto.setTotalVentas(empleadosRepository.cantidadDeVentas(empleados.getEmpleadoId()));
        dto.setTotalServicios(empleadosRepository.cantidadDeServicios(empleados.getEmpleadoId()));
        return dto;

        //Agregar una nueva linea para la columna total ventas
    }

    public EmpleadosService(EmpleadosRepository empleadosRepository) {
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

    public void calcularSueldoFinal(Integer empleadoId){
        Empleados empleados = empleadosRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        double sueldoFinal = empleados.getSueldoTotal() + empleados.getComisionesPorVentas() + empleados.getComisionPorServicio();
        empleados.setSueldoFinal(sueldoFinal);

        empleadosRepository.save(empleados);

    }

    public EmpleadosResponseDTO actualizarEmpleado(Integer id, EmpleadosRequestDTO dto){
        Empleados empleadoExistente = empleadosRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        empleadoExistente.setNombreEmpleado(dto.getNombreEmpleado());
        empleadoExistente.setTipoEmpleado(dto.getTipoEmpleado());
        empleadoExistente.setHorasTrabajadas(dto.getHorasTrabajadas());
        empleadoExistente.setSueldoPorHora(dto.getSueldoPorHora());
        empleadoExistente.setSueldoTotal(dto.getSueldoPorHora() * dto.getHorasTrabajadas());

        empleadosRepository.save(empleadoExistente);
        return mapToDTO(empleadoExistente);
    }
}
