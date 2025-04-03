package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Servicios;
@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer>{

}
