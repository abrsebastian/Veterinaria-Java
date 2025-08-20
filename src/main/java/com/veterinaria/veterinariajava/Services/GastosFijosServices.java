package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.DTO.GastosFijosRequestDTO;
import com.veterinaria.veterinariajava.DTO.GastosFijosResponseDTO;
import com.veterinaria.veterinariajava.Models.TipoDeGasto;
import com.veterinaria.veterinariajava.Repository.GastosFijosRepository;
import com.veterinaria.veterinariajava.Tables.GastosFijos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GastosFijosServices {

    @Autowired
    private GastosFijosRepository gastosFijosRepository;

    public List<GastosFijos> obtenerTodas(){
        return gastosFijosRepository.findAll();
    }

    public Optional<GastosFijos> obtenerPorId(Integer id){
        return gastosFijosRepository.findById(id);
    }

    public GastosFijosResponseDTO registrarGastoFijo(GastosFijosRequestDTO dto){

        GastosFijos gastosFijos = new GastosFijos();
        gastosFijos.setTipoDeGasto(dto.getTipoDeGasto());
        gastosFijos.setMontoGasto(dto.getMonto());

        gastosFijosRepository.save(gastosFijos);

        return new GastosFijosResponseDTO(
                gastosFijos.getGastoFijoId(),
                gastosFijos.getTipoDeGasto(),
                gastosFijos.getMontoGasto(),
                gastosFijos.getFecha()
        );
    }

    public void registrarGastoFijoPorSueldo(double totalSueldos, int month, int year){
        GastosFijos gastosFijos = new GastosFijos();

        gastosFijos.setTipoDeGasto(TipoDeGasto.SUELDOS);
        gastosFijos.setMontoGasto(totalSueldos);
        gastosFijos.setYear(year);
        gastosFijos.setMonth(month);
        gastosFijos.setFecha(LocalDateTime.now());

        gastosFijosRepository.save(gastosFijos);
    }

    public GastosFijos guardarGanancia(GastosFijos gastosFijos){
        return gastosFijosRepository.save(gastosFijos);
    }

    public void eliminarGanancia(Integer id){
        gastosFijosRepository.deleteById(id);
    }

}
