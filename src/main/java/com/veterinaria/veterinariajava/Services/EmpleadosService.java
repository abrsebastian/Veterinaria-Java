package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;

@Service
public class EmpleadosService {
    @Autowired
    final private EmpleadosRepository empleadosRepository;

    public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

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

        double sueldoFinal = empleados.getSueldoTotal() + empleados.getComisionesTotal();
        empleados.setSueldoFinal(sueldoFinal);

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
