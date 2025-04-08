package com.veterinaria.veterinariajava.Controllers;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Services.EmpleadoService;


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

    @PutMapping("/{id}")
    public ResponseEntity<Empleados> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleados empleadoActualizado){
        try {
            Empleados actualizado = empleadoService.actualizarEmpleado(id, empleadoActualizado);
            return ResponseEntity.ok(actualizado);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}