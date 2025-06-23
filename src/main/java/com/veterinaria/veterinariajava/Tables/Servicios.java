package com.veterinaria.veterinariajava.Tables;

import com.veterinaria.veterinariajava.Models.TipoDeServicio;
import jakarta.persistence.*;

@Entity
@Table(name = "servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Integer servicioId;

    @Column(name ="nombre_servicio")
    private String nombreServicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servicio")
    private TipoDeServicio tipoServicio;

    @Column(name = "profesional")
    private String nombreDelProfesional;

    @Column(name = "precio_servicio")
    private double precioServicio;

    @Column(name = "porcentaje_ganancia_local")
    private Double porcentajeGananciaLocal;

    @Column(name = "porcentaje_comision_empleado")
    private Double porcentajeBonificacionEmpleado;

    @Column(name = "precio_final")
    private Double precioFinal;

    public Servicios(){

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

    public TipoDeServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoDeServicio tipoServicio) {
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
