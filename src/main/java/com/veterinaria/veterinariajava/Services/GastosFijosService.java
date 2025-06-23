package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.Repository.GananciasRepository;
import com.veterinaria.veterinariajava.Repository.GastosFijosRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;
import com.veterinaria.veterinariajava.Tables.GastosFijos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastosFijosService {

    @Autowired
    private GastosFijosRepository gastosFijosRepository;

    public List<GastosFijos> obtenerTodas(){
        return gastosFijosRepository.findAll();
    }

    public Optional<GastosFijos> obtenerPorId(Integer id){
        return gastosFijosRepository.findById(id);
    }

    public GastosFijos guardarGanancia(GastosFijos gastosFijos){
        return gastosFijosRepository.save(gastosFijos);
    }

    public void eliminarGanancia(Integer id){
        gastosFijosRepository.deleteById(id);
    }

}
