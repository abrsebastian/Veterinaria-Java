package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.GastosFijos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosFijosRepository extends JpaRepository<GastosFijos, Integer> {

}
