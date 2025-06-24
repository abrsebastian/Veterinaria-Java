package com.veterinaria.veterinariajava.DTO;

public class ServiciosInternosRequestDTO {
    String nombreServicio;
    Integer idProfesional;
    Double precioBase;
    Double porcentajeComision;

    public Integer getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
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
}
