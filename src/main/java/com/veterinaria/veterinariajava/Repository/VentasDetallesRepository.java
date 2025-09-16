package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.Ventas;
import com.veterinaria.veterinariajava.Tables.VentasDetalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasDetallesRepository extends JpaRepository<VentasDetalles, Integer> {
    List<VentasDetalles> findByVenta(Ventas venta);
}
