package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.ServiciosInternos;
@Repository
public interface ServiciosInternosRepository extends JpaRepository<ServiciosInternos, Integer>{

}
