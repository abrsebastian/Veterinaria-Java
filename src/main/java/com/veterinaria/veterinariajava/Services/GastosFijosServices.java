package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.DTO.GastosFijosRequestDTO;
import com.veterinaria.veterinariajava.DTO.GastosFijosResponseDTO;
import com.veterinaria.veterinariajava.Models.TipoDeGasto;
import com.veterinaria.veterinariajava.Repository.GastosFijosRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;
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

    private GastosFijos mapToEntity(GastosFijosRequestDTO dto){
        GastosFijos gastosFijos = new GastosFijos();

        gastosFijos.setTipoDeGasto(dto.getTipoDeGasto());
        gastosFijos.setMontoGasto(dto.getMonto());

        LocalDateTime ahora = LocalDateTime.now();

        gastosFijos.setFecha(ahora);
        gastosFijos.setYear(ahora.getYear());
        gastosFijos.setMonth(ahora.getMonthValue());

        return gastosFijos;
    }

    private GastosFijosResponseDTO mapToDTO(GastosFijos gastosFijos){
        GastosFijosResponseDTO dto = new GastosFijosResponseDTO();
        dto.setGastoFijoId(gastosFijos.getGastoFijoId());
        dto.setMontoGastoFijo(gastosFijos.getMontoGasto());
        dto.setTipoDeGasto(gastosFijos.getTipoDeGasto());
        return dto;
    }

    public GastosFijosResponseDTO registrarGastoFijo(GastosFijosRequestDTO dto){

        GastosFijos gastosFijos = mapToEntity(dto);
        GastosFijos gastoGuardado = gastosFijosRepository.save(gastosFijos);

        return mapToDTO(gastoGuardado);
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

    public void eliminarGastoFijo(Integer id){
        gastosFijosRepository.deleteById(id);
    }

}
