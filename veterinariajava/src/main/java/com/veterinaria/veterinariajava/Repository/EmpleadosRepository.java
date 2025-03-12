package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.veterinariajava.Tables.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

}
