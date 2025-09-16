package com.veterinaria.veterinariajava.DTO;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;

import java.util.List;

public class VentasRequestDTO {

    @NotNull(message = "El ID del empleado no puede ser nulo")
    private Integer empleadoId;

    private List<ProductoVentaDTO> productos;

    public VentasRequestDTO() {
    }

    public VentasRequestDTO(Integer empleadoId, List<ProductoVentaDTO> productos) {
        this.empleadoId = empleadoId;
        this.productos = productos;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public List<ProductoVentaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVentaDTO> productos) {
        this.productos = productos;
    }
}
