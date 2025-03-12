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
import com.veterinaria.veterinariajava.Tables.Categorias;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Services.CategoriaService;

@RestController
@RequestMapping("/categorias")

public class CategoriasController {
    
    @Autowired
    private CategoriaService categoriaService;

    public List<Categorias>listarCategorias(){
        return categoriaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Categorias> obtenerCategorria(@PathVariable Integer id){
        return categoriaService.obtenerPorId(id);
    }

    @PostMapping("path")
    public Categorias crearCategoria(@RequestBody Categorias categorias) {
        return categoriaService.guardarCategoria(categorias);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Integer id){
        categoriaService.eliminarCategoria(id);
    }
}
