package com.veterinaria.veterinariajava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.veterinariajava.Tables.Ventas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentasRepository extends JpaRepository<Ventas,Integer>{

    @Query(value = "SELECT * FROM ventas v WHERE v.empleado_id = :empleado_id AND YEAR (v.fecha) = :year AND MONTH (v.fecha) = :month;", nativeQuery = true)
    List<Ventas> findEmpleadoIdAndFecha(@Param("year") int year, @Param("month") int month, @Param("empleadoId") Integer empleadoId);

    @Query(
            value = "SELECT v FROM Ventas v " +
                    "JOIN FETCH v.empleados e " +
                    "JOIN FETCH v.detallesList d " +
                    "JOIN FETCH d.productos p")
    List<Ventas>findAllConDetallesYProductos();
}
