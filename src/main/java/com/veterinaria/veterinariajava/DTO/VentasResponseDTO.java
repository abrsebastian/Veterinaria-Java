package com.veterinaria.veterinariajava.DTO;

public class VentasResponseDTO {
    private Integer productoId;
    private String nombreProducto;
    private Double precioUnitario;
    private Long cantidad;
    private Double precioTotal;
    private Integer empleadoId;
    private String nombreEmpleado;
    private String tipoEmpleado;
    private Double comision;

    public VentasResponseDTO(Integer productoId, String nombreProducto, Integer empleadoId, String tipoEmpleado, String nombreEmpleado, double precioUnitario, long cantidad, double total, double comision){
        this.productoId = productoId;
        this.nombreProducto = this.nombreProducto;
        this.precioUnitario = this.precioUnitario;
        this.cantidad = this.cantidad;
        this.precioTotal =precioTotal;
        this.empleadoId = this.empleadoId;
        this.nombreEmpleado = this.nombreEmpleado;
        this.tipoEmpleado = this.tipoEmpleado;
        this.comision = this.comision;
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
