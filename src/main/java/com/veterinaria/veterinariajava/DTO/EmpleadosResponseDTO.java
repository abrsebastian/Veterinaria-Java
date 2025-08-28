package com.veterinaria.veterinariajava.DTO;

public class EmpleadosResponseDTO {

    private Integer empleadoId;
    private String nombreEmpleado;
    private String tipoEmpleado;
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


    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }
}
