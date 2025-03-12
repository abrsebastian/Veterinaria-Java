package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.veterinariajava.Tables.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
