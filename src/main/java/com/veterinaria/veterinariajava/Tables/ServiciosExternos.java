package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "servicios_externos")

public class ServiciosExternos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_ext_id")
    private Integer servicioExternoId;

    @Column(name = "profesional")
    private String profesional;

    @Column(name = "contacto")
    private Long numeroDeContacto;

    @Column(name = "empresa")
    private String nombreEmpresa;

    @Column(name = "costo_servicio")
    private Double costoServicioExterno;

    @Column(name = "porcentaje_agregado")
    private Double porcentajeAgregado;

    @Column(name = "precio_final")
    private Double precioFinal;

    @Column(name = "fecha")
    @CreationTimestamp
    private Date fecha;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    public ServiciosExternos() {
    }

    public Integer getServicioExternoId() {
        return servicioExternoId;
    }

    public void setServicioExternoId(Integer servicioExternoId) {
        this.servicioExternoId = servicioExternoId;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public Long getNumeroDeContacto() {
        return numeroDeContacto;
    }

    public void setNumeroDeContacto(Long numeroDeContacto) {
        this.numeroDeContacto = numeroDeContacto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Double getCostoServicioExterno() {
        return costoServicioExterno;
    }

    public void setCostoServicioExterno(Double costoServicioExterno) {
        this.costoServicioExterno = costoServicioExterno;
    }

    public Double getPorcentajeAgregado() {
        return porcentajeAgregado;
    }

    public void setPorcentajeAgregado(Double porcentajeAgregado) {
        this.porcentajeAgregado = porcentajeAgregado;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
