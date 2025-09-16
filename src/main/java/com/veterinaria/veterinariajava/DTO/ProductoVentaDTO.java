package com.veterinaria.veterinariajava.DTO;

public class ProductoVentaDTO {

    private Integer productoId;
    private int cantidad;

    public ProductoVentaDTO() {
    }

    public ProductoVentaDTO(Integer productoId, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
