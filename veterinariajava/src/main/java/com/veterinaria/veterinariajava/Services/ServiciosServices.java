package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Repository.ServiciosRepository;
import com.veterinaria.veterinariajava.Tables.Servicios;

@Service
public class ServiciosServices {
    @Autowired
     private ServiciosRepository serviciosRepository;

    public List<Servicios>obtenerTodos(){
        return serviciosRepository.findAll();
    }

     public Optional<Servicios>obtenerPorId(Integer id){
        return serviciosRepository.findById(id);
    }

    public Servicios guardarServicio(Servicios servicios){
        return serviciosRepository.save(servicios);
    }

    public void eliminarServicio(Integer id){
        serviciosRepository.deleteById(id);
    }
}
