package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Tables.Categorias;
import com.veterinaria.veterinariajava.Repository.CategoriasRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias>obtenerTodas(){
        return categoriasRepository.findAll();
    }

    public Optional<Categorias>obtenerPorId(Integer id){
        return categoriasRepository.findById(id);
    }

    public Categorias guardarCategoria(Categorias categorias){
        return categoriasRepository.save(categorias);
    }

    public void eliminarCategoria(Integer id){
        categoriasRepository.deleteById(id);
    }
}
