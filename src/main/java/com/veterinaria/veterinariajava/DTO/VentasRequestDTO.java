package com.veterinaria.veterinariajava.DTO;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VentasRequestDTO {

    @NotNull(message = "El ID del Producto no puede ser nulo")
    private Integer productoId;

    @NotNull(message = "El ID del empleado no puede ser nulo")
    private Integer empleadoId;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Long cantidad;

    public VentasRequestDTO(){

    }

    public VentasRequestDTO(Integer productoId, Integer empleadoId, Long cantidad){

        this.productoId = productoId;
        this.empleadoId = empleadoId;
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
