package com.veterinaria.veterinariajava.Controllers;

import java.util.List;

import com.veterinaria.veterinariajava.DTO.VentasRequestDTO;
import com.veterinaria.veterinariajava.DTO.VentasResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.veterinariajava.Services.VentasServices;
import com.veterinaria.veterinariajava.Tables.Ventas;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasServices ventasServices;

    @GetMapping
    public List<VentasResponseDTO> obtenerTodasLasVentas() {
        return ventasServices.obtenerTodasLasVentas();
    }

    @PostMapping
    public ResponseEntity<VentasResponseDTO> crearVenta(@Valid @RequestBody VentasRequestDTO dto){
        VentasResponseDTO responseDTO = ventasServices.registrarVentas(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{ventaId}")
    public VentasResponseDTO actualizarVenta(@PathVariable Integer ventaId, @RequestBody Ventas nuevaVenta){
        return ventasServices.actualizarVentas(ventaId, nuevaVenta);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Integer id){
        ventasServices.eliminarVenta(id);
    }

}
