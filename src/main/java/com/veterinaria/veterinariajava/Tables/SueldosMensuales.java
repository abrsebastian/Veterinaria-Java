package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;

@Entity
@Table(name = "sueldos_mensuales")
public class SueldosMensuales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sueldo_id")
    private Integer sueldoId;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleados;

    @Column(name = "sueldo_total", nullable = true)
    private Double sueldoTotal = 0.0;

    @Column(name = "comisiones_ventas", nullable = true)
    private Double comisionesPorVentas = 0.0;

    @Column(name = "comisiones_servicios", nullable = true)
    private Double comisionPorServicio = 0.0;

    @Column(name = "sueldo_final", nullable = true)
    private Double sueldoFinal = 0.0;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    public SueldosMensuales() {}

    public Integer getSueldoId() {
        return sueldoId;
    }

    public void setSueldoId(Integer sueldoId) {
        this.sueldoId = sueldoId;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(Double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public Double getComisionesPorVentas() {
        return comisionesPorVentas;
    }

    public void setComisionesPorVentas(Double comisionesPorVentas) {
        this.comisionesPorVentas = comisionesPorVentas;
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
