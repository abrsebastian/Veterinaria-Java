package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Empleados;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
    @Query(value = "SELECT COUNT(*) as total_ventas FROM ventas WHERE empleado_id = :empleadoId", nativeQuery = true)
    Long cantidadDeVentas(@Param("empleadoId")Integer empleadoId);

    @Query(value = "SELECT COUNT(*) as cds_prestados FROM servicios WHERE empleado_id = :empleadoId", nativeQuery = true)
    Long cantidadDeServicios(@Param("empleadoId")Integer empleadoId);

}
