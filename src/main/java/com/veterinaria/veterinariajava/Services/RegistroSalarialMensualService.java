package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.Repository.RegistroSalarialMensualRepository;
import com.veterinaria.veterinariajava.Tables.RegistroSalarialMensual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroSalarialMensualService {
    @Autowired
    private RegistroSalarialMensualRepository registroSalarialMensualRepository;

    public List<RegistroSalarialMensual> obtenerTodosLosRegistros(){
        return registroSalarialMensualRepository.findAll();
    }


}
