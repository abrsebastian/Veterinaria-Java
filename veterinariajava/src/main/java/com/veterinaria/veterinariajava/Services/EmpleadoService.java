package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

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
}
