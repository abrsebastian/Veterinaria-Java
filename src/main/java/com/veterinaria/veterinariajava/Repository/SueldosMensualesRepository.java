package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.SueldosMensuales;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SueldosMensualesRepository extends JpaRepository<SueldosMensuales, Integer> {

    @Query(value = "SELECT * FROM sueldos_mensuales WHERE year = :year AND month = :month", nativeQuery = true)
    Optional<SueldosMensuales> findByEmpleadoAndYearAndMonthNative(@Param("year") int year, @Param("month") int month);

    @Query(value = "SELECT * FROM sueldos_mensuales WHERE year = :year AND month = :month", nativeQuery = true)
    List<SueldosMensuales> obtenerListaSueldos(@Param("year") int year, @Param("month") int month);

}

