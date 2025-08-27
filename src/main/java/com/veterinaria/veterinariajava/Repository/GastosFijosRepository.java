package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.GastosFijos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosFijosRepository extends JpaRepository<GastosFijos, Integer> {
    @Query(value = "SELECT SUM(monto) FROM gastos_fijos gf WHERE MONTH (gf.fecha) = :month AND YEAR (gf.fecha) = :year", nativeQuery = true)
    Double montoTotalGastosFijos(@Param("month")int month, @Param("year")int year);
}
