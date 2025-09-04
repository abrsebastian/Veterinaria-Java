package com.veterinaria.veterinariajava.Repository;

import com.veterinaria.veterinariajava.Tables.Ventas;
import com.veterinaria.veterinariajava.Tables.VentasDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentasDetallesRepository extends JpaRepository<VentasDetalles, Integer> {
    List<VentasDetalles>findByVentas(Ventas ventas);
}
