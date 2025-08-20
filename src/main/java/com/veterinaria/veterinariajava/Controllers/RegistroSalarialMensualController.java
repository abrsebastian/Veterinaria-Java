package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.Services.RegistroSalarialMensualService;
import com.veterinaria.veterinariajava.Tables.RegistroSalarialMensual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro_salarial_mensual")

public class RegistroSalarialMensualController {

    @Autowired
    private RegistroSalarialMensualService registroSalarialMensualService;

    @GetMapping
    public List<RegistroSalarialMensual> ListarRegistros(){
        return registroSalarialMensualService.obtenerTodosLosRegistros();
    }

    @DeleteMapping("/{id}")
    public void eliminarRegistro(@PathVariable Integer id){
        registroSalarialMensualService.eliminarRegistro(id);
    }
}
