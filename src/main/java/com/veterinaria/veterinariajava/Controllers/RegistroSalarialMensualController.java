package com.veterinaria.veterinariajava.Controllers;

import com.veterinaria.veterinariajava.Services.RegistroSalarialMensualService;
import com.veterinaria.veterinariajava.Tables.RegistroSalarialMensual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
