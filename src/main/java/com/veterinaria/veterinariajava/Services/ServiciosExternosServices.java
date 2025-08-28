package com.veterinaria.veterinariajava.Services;


import com.veterinaria.veterinariajava.DTO.ServiciosExternosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ServiciosExternosResponseDTO;
import com.veterinaria.veterinariajava.Repository.ServiciosExternosRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;
import com.veterinaria.veterinariajava.Tables.ServiciosExternos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosExternosServices {

    @Autowired
    ServiciosExternosRepository serviciosExternosRepository;

    private ServiciosExternosResponseDTO mapToEntity(ServiciosExternos serviciosExternos){
        ServiciosExternosResponseDTO dto = new ServiciosExternosResponseDTO();
        dto.setServicioExternoId(serviciosExternos.getServicioExternoId());
        dto.setProfesional(serviciosExternos.getProfesional());
        dto.setNombreEmpresa(serviciosExternos.getNombreEmpresa());
        dto.setNumeroDeContacto(serviciosExternos.getNumeroDeContacto());
        dto.setCostoServicioExterno(serviciosExternos.getCostoServicioExterno());
        dto.setPorcentajeAgregado(serviciosExternos.getPorcentajeAgregado());
        dto.setPrecioFinal(serviciosExternos.getPrecioFinal());
        dto.setTipoDeServicio(serviciosExternos.getNombreServicio());
        dto.setComisionLocal(serviciosExternos.getComisionLocal());

        return dto;
    }

    public List<ServiciosExternosResponseDTO>obtenerTodos(){
        return serviciosExternosRepository.findAll().stream()
                .map(this::mapToEntity).toList();
    }

    @Transactional
    public ServiciosExternosResponseDTO registrarServicioExterno(ServiciosExternosRequestDTO dto){
        ServiciosExternos serviciosExternos = new ServiciosExternos();

        Double costoServicio = dto.getCostoServicioExterno();
        Double porcentajeAgregado = (dto.getPorcentajeAgregado()/100);
        Double precioFinal = costoServicio + (costoServicio * porcentajeAgregado);
        Double comisionLocal = costoServicio * porcentajeAgregado;

        serviciosExternos.setNombreServicio(dto.getTipoDeServicio());
        serviciosExternos.setProfesional(dto.getProfesional());
        serviciosExternos.setNombreEmpresa(dto.getNombreEmpresa());
        serviciosExternos.setCostoServicioExterno(costoServicio);
        serviciosExternos.setPorcentajeAgregado(dto.getPorcentajeAgregado());
        serviciosExternos.setPrecioFinal(precioFinal);
        serviciosExternos.setNumeroDeContacto(dto.getNumeroDeContacto());
        serviciosExternos.setNombreServicio(dto.getTipoDeServicio());
        serviciosExternos.setComisionLocal(comisionLocal);

        ServiciosExternos sExternoGuardado = serviciosExternosRepository.save(serviciosExternos);

        return mapToEntity(sExternoGuardado);

    }

    public void eliminarServicioExterno(Integer id){
        serviciosExternosRepository.deleteById(id);
    }



}
