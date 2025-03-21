package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.veterinaria.veterinariajava.Repository.GananciasRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;

public class VentasServices {
      @Autowired
    private GananciasRepository gananciasRepository;

    public List<Ganancias>obtenerTodas(){
        return gananciasRepository.findAll();
    }

     public Optional<Ganancias>obtenerPorId(Integer id){
        return gananciasRepository.findById(id);
    }

    public Ganancias guardarGanancia(Ganancias ganancias){
        return gananciasRepository.save(ganancias);
    }

    public void eliminarGanancia(Integer id){
        gananciasRepository.deleteById(id);
    }
}

//falta implementar service y controllers para poder continuar con el resto de la logica y ver si funciona la parte de calculos, posteriormente se seguira con el resto de las tablas 