package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.DTO.GastosFijosRequestDTO;
import com.veterinaria.veterinariajava.DTO.GastosFijosResponseDTO;
import com.veterinaria.veterinariajava.Services.GastosFijosServices;
import com.veterinaria.veterinariajava.Tables.GastosFijos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos_fijos")

public class GastosFijosController {

    @Autowired
    private GastosFijosServices gastosFijosServices;

    @GetMapping
    public List<GastosFijos>todosLosGastosFijos(){
        return gastosFijosServices.obtenerTodas();
    }

    @DeleteMapping("/{id}")
    public void eliminarGastoFijo(@PathVariable Integer id){
        gastosFijosServices.eliminarGastoFijo(id);
    }

    @PostMapping
    public ResponseEntity<GastosFijosResponseDTO>crearGastoFijo(@Valid @RequestBody GastosFijosRequestDTO dto){
        GastosFijosResponseDTO responseDTO = gastosFijosServices.registrarGastoFijo(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
