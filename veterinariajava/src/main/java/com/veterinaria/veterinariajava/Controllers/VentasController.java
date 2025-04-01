package com.veterinaria.veterinariajava.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.veterinariajava.Services.VentasServices;
import com.veterinaria.veterinariajava.Tables.Ventas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ResponseEntity<Ventas>registrarVentas(@RequestBody Ventas ventas){
        Ventas nuevaVentas = ventasServices.registrarVentas(
            ventas.getProductos().getProductoId(),
            ventas.getEmpleados().getEmpleadoId(),
            ventas.getCantidadProductoVendido());
        return ResponseEntity.ok(nuevaVentas);
    }

    // public Ventas registrarVenta(@RequestParam Integer productoId, @RequestParam Integer empleadoId,
    //         @RequestParam int cantidad) {
    //     return ventasServices.ventasRegistradas(productoId, empleadoId, cantidad);
    // }



}
