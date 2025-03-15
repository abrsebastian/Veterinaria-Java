package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Ganancias;
@Repository
public interface GananciasRepository extends JpaRepository<Ganancias, Integer> {

}
