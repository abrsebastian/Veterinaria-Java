package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
