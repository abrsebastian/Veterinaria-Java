package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.Services.GastosFijosServices;
import com.veterinaria.veterinariajava.Tables.GastosFijos;
import org.springframework.beans.factory.annotation.Autowired;
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
}
