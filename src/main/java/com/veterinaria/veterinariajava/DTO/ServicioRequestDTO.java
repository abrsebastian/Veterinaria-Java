package com.veterinaria.veterinariajava.DTO;

import com.veterinaria.veterinariajava.Models.TipoDeServicio;

public class ServicioRequestDTO {
    String nombreServicio;
    String nombreProfesional;
    String tipoServicio;
    Double precioBase;
    Double comisionServicio;

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public Double getComisionServicio() {
        return comisionServicio;
    }

    public void setComisionServicio(Double comisionServicio) {
        this.comisionServicio = comisionServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public TipoDeServicio getTipoServicio() {
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
}
