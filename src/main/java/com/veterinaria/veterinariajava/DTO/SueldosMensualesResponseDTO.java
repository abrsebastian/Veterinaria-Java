package com.veterinaria.veterinariajava.DTO;

public class SueldosMensualesResponseDTO {

    private Integer empleadoId;
    private String nombreEmpleado;
    private Double sueldoTotal;
    private Double comisionPorVenta;
    private Double comisionPorServicio;
    private Double sueldoFinal;

    public SueldosMensualesResponseDTO() {
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

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(Double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public Double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta(Double comisionPorVenta) {
        this.comisionPorVenta = comisionPorVenta;
    }

    public Double getComisionPorServicio() {
        return comisionPorServicio;
    }

    public void setComisionPorServicio(Double comisionPorServicio) {
        this.comisionPorServicio = comisionPorServicio;
    }

    public Double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(Double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }
}
