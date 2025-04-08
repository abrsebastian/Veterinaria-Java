package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadosRepository empleadosRepository;

    public List<Empleados>obtenerTodos(){
        return empleadosRepository.findAll();
    }

    public Optional<Empleados>obtenerPorId(Integer id){
        return empleadosRepository.findById(id);
    }

    public Empleados guardarEmpleados(Empleados empleados){
        return empleadosRepository.save(empleados);
    }

    public void eliminarEmpleado(Integer id){
        empleadosRepository.deleteById(id);
    }

    public void calcularSueldoFinal(Integer empleadoId){
        Empleados empleados = empleadosRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        double sueldoFInal = empleados.getSueldoTotal() + empleados.getComisionesTotal();
        empleados.setSueldoFinal(sueldoFInal);

        empleadosRepository.save(empleados);
    }

    public Empleados actualizarEmpleado(Integer id, Empleados empleadoActualizado){
        empleadosRepository.findById(id).map(empleados -> {
            empleados.setNombreEmpleado(empleadoActualizado.getNombreEmpleado());
            empleados.setTipoEmpleado(empleadoActualizado.getTipoEmpleado());
            empleados.setHorasTrabajadas(empleadoActualizado.getHorasTrabajadas());
            empleados.setSueldoTotal(empleadoActualizado.getSueldoTotal());
            return  empleadosRepository.save(empleados);
        });
        return empleadoActualizado;
    }
}
