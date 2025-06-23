package com.veterinaria.veterinariajava.DTO;

public class ServicioResponseDTO {
    private Integer servicioId;
    private String nombreServicio;
    private String tipoServicio;
    private Double precioBase;
    private Double porcentajeGananciaLocal;
    private Double porcentajeBonificacionEmpleado;
    private Double precioFinal;

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double getPorcentajeGananciaLocal() {
        return porcentajeGananciaLocal;
    }

    public void setPorcentajeGananciaLocal(Double porcentajeGananciaLocal) {
        this.porcentajeGananciaLocal = porcentajeGananciaLocal;
    }

    public Double getPorcentajeBonificacionEmpleado() {
        return porcentajeBonificacionEmpleado;
    }

    public void setPorcentajeBonificacionEmpleado(Double porcentajeBonificacionEmpleado) {
        this.porcentajeBonificacionEmpleado = porcentajeBonificacionEmpleado;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
