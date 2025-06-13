package com.veterinaria.veterinariajava.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductosRequestDTO {

    @NotNull(message = "Este campo no puede estar vacío")
    private String nombreProducto;

    @NotNull(message = "Este campo no puede estar vacío")
    @Positive(message = "EL precio debe ser mayor a cero")
    private Double precioCostoProducto;

    @NotNull(message = "Este campo no puede estar vacío")
    @Min(value = 0, message = "El porcentaje debe ser mayor o igual a cero")
    private Double porcentajeVenta;

    @NotNull(message = "Este campo no puede estar vacío")
    @Min(value = 0, message = "El Stock debe ser mayor o igual a cero")
    private int stockProducto;

    @NotNull(message = "Este campo no puede estar vacío")
    private Integer proveedorId;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioCostoProducto() {
        return precioCostoProducto;
    }

    public void setPrecioCostoProducto(Double precioCostoProducto) {
        this.precioCostoProducto = precioCostoProducto;
    }

    public Double getPorcentajeVenta() {
        return porcentajeVenta;
    }

    public void setPorcentajeVenta(Double porcentajeVenta) {
        this.porcentajeVenta = porcentajeVenta;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }
}
