package com.veterinaria.veterinariajava.Services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.Tables.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.veterinariajava.Repository.GananciasRepository;

import com.veterinaria.veterinariajava.Tables.Ganancias;

@Service
public class GananciaService {
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

    public void registrarGananciasDesdeServicios(Servicios servicios){
        Ganancias ganancias = new Ganancias();
        ganancias.setServicioId(servicios);
        ganancias.setTotalIngresos(servicios.getPrecioServicio());
        ganancias.setTotalGanancia(servicios.getPrecioServicio() * 0.3);
        gananciasRepository.save(ganancias);
     }
}
