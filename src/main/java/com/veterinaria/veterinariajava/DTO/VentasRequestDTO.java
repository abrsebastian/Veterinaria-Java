package com.veterinaria.veterinariajava.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;

public class VentasRequestDTO {
    private Integer productoId;
    private Integer empleadoId;
    private long cantidad;

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

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
}
