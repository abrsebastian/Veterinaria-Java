package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Proveedores;
@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {

}
