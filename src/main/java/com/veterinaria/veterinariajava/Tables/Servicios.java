package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Integer servicioId;

    @Column(name ="nombre_servicio")
    private String nombreServicio;

    @Column(name = "tipo_servicio")
    private String tipoServicio;

    @Column(name = "profesional")
    private String nombreDelProfesional;

    @Column(name = "precio_servicio")
    private double precioServicio;

    public Servicios(){

    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getNombreDelProfesional() {
        return nombreDelProfesional;
    }

    public void setNombreDelProfesional(String nombreDelProfesional) {
        this.nombreDelProfesional = nombreDelProfesional;
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

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

}
