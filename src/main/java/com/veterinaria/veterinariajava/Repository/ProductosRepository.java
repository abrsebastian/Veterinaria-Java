package com.veterinaria.veterinariajava.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.veterinariajava.Tables.Productos;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    @Query("SELECT p FROM Productos p WHERE LOWER(p.nombreProducto) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Productos> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);

    @Query("SELECT p FROM Productos p WHERE p.proveedor.proveedorId = :proveedorId")
    List<Productos> findByProveedorId(@Param("proveedorId")Integer proveedorId);

    @Query(value = "SELECT COUNT(*) as cdv_vendido FROM VENTAS where producto_id = :productoId", nativeQuery = true)
    Long cantidadDeVecesVendido(@Param("productoId")Integer productoId);

}
