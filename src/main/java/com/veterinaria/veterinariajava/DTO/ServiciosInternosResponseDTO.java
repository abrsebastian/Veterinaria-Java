package com.veterinaria.veterinariajava.DTO;

public class ServiciosInternosResponseDTO {
    private Integer servicioId;
    private Integer empleadoId;
    private String nombreEmpleado;
    private String nombreServicio;
    private Double precioBase;
    private Double porcentajeEmpleado;
    private Double precioFinal;

    public ServiciosInternosResponseDTO(){}

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

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double getPorcentajeEmpleado() {
        return porcentajeEmpleado;
    }

    public void setPorcentajeEmpleado(Double porcentajeEmpleado) {
        this.porcentajeEmpleado = porcentajeEmpleado;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
