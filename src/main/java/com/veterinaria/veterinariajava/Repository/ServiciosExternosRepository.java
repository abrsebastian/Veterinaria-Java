package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.ServiciosExternos;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosExternosRepository extends JpaRepository<ServiciosExternos, Integer> {
}
