package com.veterinaria.veterinariajava.Tables;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "registro_salarial_mensual",
        uniqueConstraints = @UniqueConstraint(columnNames = {"empleado_id", "year", "month"}))
public class RegistroSalarialMensual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Integer registroId;

    @Column(name = "empleado_id", nullable = false)
    private Integer empleadoHistoricoId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "sueldo_base")
    private Double sueldoBase;

    @Column(name = "comision_ventas")
    private Double comisionVentas;

    @Column(name = "comision_servicios")
    private Double comisionServicios;

    @Column(name = "sueldo_final")
    private Double sueldoFinal;

    @Column(name = "fecha")
    private LocalDate fechaGeneracion;

    public Integer getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Integer registroId) {
        this.registroId = registroId;
    }

    public Integer getEmpleadoHistoricoId() {
        return empleadoHistoricoId;
    }

    public void setEmpleadoHistoricoId(Integer empleadoHistoricoId) {
        this.empleadoHistoricoId = empleadoHistoricoId;
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

    public Double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Double getComisionVentas() {
        return comisionVentas;
    }

    public void setComisionVentas(Double comisionVentas) {
        this.comisionVentas = comisionVentas;
    }

    public Double getComisionServicios() {
        return comisionServicios;
    }

    public void setComisionServicios(Double comisionServicios) {
        this.comisionServicios = comisionServicios;
    }

    public Double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(Double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
}
