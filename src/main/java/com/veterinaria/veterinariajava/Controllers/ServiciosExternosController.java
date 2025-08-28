package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.DTO.ServiciosExternosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ServiciosExternosResponseDTO;
import com.veterinaria.veterinariajava.Services.ServiciosExternosServices;
import com.veterinaria.veterinariajava.Tables.ServiciosExternos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios_externos")
public class ServiciosExternosController {

    @Autowired
    ServiciosExternosServices serviciosExternosServices;

    @GetMapping
    public List<ServiciosExternosResponseDTO>listarServicios(){
        return serviciosExternosServices.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<ServiciosExternosResponseDTO>crearServicioExterno(@Valid @RequestBody ServiciosExternosRequestDTO dto){
        ServiciosExternosResponseDTO responseDTO = serviciosExternosServices.registrarServicioExterno(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Integer id){
        serviciosExternosServices.eliminarServicioExterno(id);
    }

}
