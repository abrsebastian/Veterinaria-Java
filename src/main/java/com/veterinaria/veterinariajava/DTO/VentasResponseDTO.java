package com.veterinaria.veterinariajava.DTO;

import java.time.LocalDateTime;

public class VentasResponseDTO {
    private Integer ventaId;
    private Integer productoId;
    private String nombreProducto;
    private Double precioUnitario;
    private Long cantidad;
    private Double precioTotal;
    private Integer empleadoId;
    private String nombreEmpleado;
    private String tipoEmpleado;
    private Double comision;
    private LocalDateTime fecha;

    public VentasResponseDTO(Integer ventaId,
                             Integer productoId,
                             String nombreProducto,
                             Integer empleadoId,
                             String tipoEmpleado,
                             String nombreEmpleado,
                             double precioUnitario,
                             long cantidad,
                             double total,
                             double comision,
                             LocalDateTime fecha){
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.precioTotal =total;
        this.empleadoId = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.tipoEmpleado = tipoEmpleado;
        this.comision = comision;
        this.fecha = fecha;
    }

    public VentasResponseDTO() {

    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }
}
