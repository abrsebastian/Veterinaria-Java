package com.veterinaria.veterinariajava.Services;


import com.veterinaria.veterinariajava.DTO.ServiciosExternosRequestDTO;
import com.veterinaria.veterinariajava.Repository.ServiciosExternosRepository;
import com.veterinaria.veterinariajava.Tables.Ganancias;
import com.veterinaria.veterinariajava.Tables.ServiciosExternos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosExternosServices {

    @Autowired
    ServiciosExternosRepository serviciosExternosRepository;

    public List<ServiciosExternos>obtenerTodos(){
        return serviciosExternosRepository.findAll();
    }

    public ServiciosExternos registrarServicioExterno(ServiciosExternosRequestDTO dto){
        ServiciosExternos serviciosExternos = new ServiciosExternos();

        Double costoServicio = dto.getCostoServicioExterno();


        porcentajeAgregado
                precioFinal

    }

    public void eliminarServicioExterno(Integer id){
        serviciosExternosRepository.deleteById(id);
    }



}
