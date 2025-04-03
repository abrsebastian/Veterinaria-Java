package com.veterinaria.veterinariajava.Controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Services.EmpleadoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/empleados")

public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleados> listarEmpleados(){
        return empleadoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Empleados> obtenerEmpleado(@PathVariable Integer id){
        return empleadoService.obtenerPorId(id);
    }

    @PostMapping
    public Empleados crearEmpleados(@RequestBody Empleados empleados) {
        return empleadoService.guardarEmpleados(empleados);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Integer id){
        empleadoService.eliminarEmpleado(id);
    }
    
}