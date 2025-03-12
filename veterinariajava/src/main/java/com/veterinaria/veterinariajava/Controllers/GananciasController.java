package com.veterinaria.veterinariajava.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.veterinaria.veterinariajava.Services.GananciaService;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.Ganancias;

@RestController
@RequestMapping("/ganancias")

public class GananciasController {

    @Autowired
    private GananciaService gananciaService;

    public List<Ganancias> listaGanancias(){
        return gananciaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Ganancias> obtenerGanancia(@PathVariable Integer id){
        return gananciaService.obtenerPorId(id);
    }

    @PostMapping("path")
    public Ganancias crearGanancia(@RequestBody Ganancias ganancias) {
        return gananciaService.guardarGanancia(ganancias);
    }

    @DeleteMapping("/{id}")
    public void eliminarGanancia(@PathVariable Integer id){
        gananciaService.eliminarGanancia(id);
    }

}
