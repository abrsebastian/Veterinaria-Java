package com.veterinaria.veterinariajava.Controllers;
import java.util.List;

import com.veterinaria.veterinariajava.DTO.EmpleadosRequestDTO;
import com.veterinaria.veterinariajava.DTO.EmpleadosResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinariajava.Services.EmpleadosServices;


@RestController
@RequestMapping("/empleados")

public class EmpleadosController {

    @Autowired
    private EmpleadosServices empleadoService;

    @GetMapping
    public List<EmpleadosResponseDTO> listarEmpleados(){
        return empleadoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosResponseDTO> obtenerEmpleado(@PathVariable Integer id){
        return empleadoService.obtenerPorId(id).
                map(empleados
                        -> ResponseEntity.ok().body(empleados)).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpleadosResponseDTO> crearEmpleados(@Valid @RequestBody EmpleadosRequestDTO dto) {
        EmpleadosResponseDTO creado = empleadoService.guardarEmpleados(dto);
        return ResponseEntity.ok(creado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadosResponseDTO> actualizarEmpleado(@PathVariable Integer id,
                                                                   @Valid @RequestBody EmpleadosRequestDTO dto){
        try {
            EmpleadosResponseDTO actualizado = empleadoService.actualizarEmpleado(id, dto);
            return ResponseEntity.ok(actualizado);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}