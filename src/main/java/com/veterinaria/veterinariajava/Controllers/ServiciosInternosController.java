package com.veterinaria.veterinariajava.Controllers;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.ServiciosInternosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ServiciosInternosResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.veterinaria.veterinariajava.Services.ServiciosInternosServices;

import com.veterinaria.veterinariajava.Tables.ServiciosInternos;

@RestController
@RequestMapping("/servicios")
public class ServiciosInternosController {

    @Autowired
    private ServiciosInternosServices serviciosInternosServices;
   
    @GetMapping
    public List<ServiciosInternos> listaServicios(){
        return serviciosInternosServices.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<ServiciosInternos> obtenerServicio(@PathVariable Integer id){
        return serviciosInternosServices.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<ServiciosInternosResponseDTO> crearServicio(@Valid @RequestBody ServiciosInternosRequestDTO dto) {
        ServiciosInternosResponseDTO responseDTO = serviciosInternosServices.registrarServicioInterno(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Integer id){
        serviciosInternosServices.eliminarServicio(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiciosInternos> actualizarServicio(@PathVariable Integer id, @RequestBody ServiciosInternos servicioActualizado){
        try {
            ServiciosInternos servicios = serviciosInternosServices.actualizarServicio(id, servicioActualizado);
            return ResponseEntity.ok(servicios);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
