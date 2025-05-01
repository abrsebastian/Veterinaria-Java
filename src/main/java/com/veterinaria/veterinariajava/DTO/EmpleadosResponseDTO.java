package com.veterinaria.veterinariajava.DTO;

public class EmpleadosResponseDTO {

    private Integer empleadoId;
    private String nombreEmpleado;
    private String tipoEmpleado;
    private double sueldoTotal;
    private double comisionesTotal;
    private double sueldoFinal;

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

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public double getComisionesTotal() {
        return comisionesTotal;
    }

    public void setComisionesTotal(double comisionesTotal) {
        this.comisionesTotal = comisionesTotal;
    }

    public double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }
}
