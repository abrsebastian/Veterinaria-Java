package com.veterinaria.veterinariajava.Controllers;

import java.util.List;

import com.veterinaria.veterinariajava.DTO.VentasResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.veterinariajava.Services.VentasServices;
import com.veterinaria.veterinariajava.Tables.Ventas;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasServices ventasServices;

    @GetMapping
    public List<Ventas> obtenerTodasLasVentas() {
        return ventasServices.obtenerTodasLasVentas();
    }

    @PostMapping
    public VentasResponseDTO registrarVentas(@RequestBody Ventas ventas){
          return ventasServices.registrarVentas(ventas);
    }

    @PutMapping("/{ventaId}")
    public VentasResponseDTO actualizarVenta(@PathVariable Integer ventaId, @RequestBody Ventas nuevaVenta){
        return ventasServices.actualizarVentas(ventaId, nuevaVenta);
    }

}
