package com.veterinaria.veterinariajava.DTO;

public class EmpleadosResponseDTO {

    private Integer empleadoId;
    private String nombreEmpleado;
    private String tipoEmpleado;
    private double sueldoTotal;
    private double comisionesPorVenta;
    private double comisionesPorServicios;
    private double sueldoFinal;
    private Long totalVentas;
    private Long totalServicios;

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Long getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(Long totalServicios) {
        this.totalServicios = totalServicios;
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

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public double getComisionesPorVenta() {
        return comisionesPorVenta;
    }

    public void setComisionesPorVenta(double comisionesPorVenta) {
        this.comisionesPorVenta = comisionesPorVenta;
    }

    public double getComisionesPorServicios() {
        return comisionesPorServicios;
    }

    public void setComisionesPorServicios(double comisionesPorServicios) {
        this.comisionesPorServicios = comisionesPorServicios;
    }

    public double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }

    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }
}
