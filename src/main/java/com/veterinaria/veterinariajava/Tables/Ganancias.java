package com.veterinaria.veterinariajava.Tables;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ganancias")

public class Ganancias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ganancia_id")
    private Integer gananciaId;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha; 

    @Column(name = "ib_ventas", nullable = true)
    private Double iBVentas = 0.0;

    @Column(name = "ib_servicios_internos", nullable = true)
    private Double iBServiciosInternos = 0.0;

    @Column(name = "ib_servicios_externos", nullable = true)
    private Double iBServiciosExternos = 0.0;

    @Column(name = "total_ganancia", nullable = true)
    private Double totalGanancia = 0.0;

    @Column(name = "gastos_fijos_total", nullable = true)
    private Double gastosFijosTotal = 0.0;

    @Column(name = "gananciasLocal", nullable = true)
    private Double gananciasLocal = 0.0;


    public Ganancias(){

    }

    public Double getiBVentas() {
        return iBVentas;
    }

    public void setiBVentas(Double iBVentas) {
        this.iBVentas = iBVentas;
    }

    public Double getGastosFijosTotal() {
        return gastosFijosTotal;
    }

    public void setGastosFijosTotal(Double gastosFijosTotal) {
        this.gastosFijosTotal = gastosFijosTotal;
    }

    public Double getGananciasLocal() {
        return gananciasLocal;
    }

    public void setGananciasLocal(Double gananciasLocal) {
        this.gananciasLocal = gananciasLocal;
    }

    public Double getiBServiciosInternos() {
        return iBServiciosInternos;
    }

    public void setiBServiciosInternos(Double iBServiciosInternos) {
        this.iBServiciosInternos = iBServiciosInternos;
    }

    public Double getiBServiciosExternos() {
        return iBServiciosExternos;
    }

    public void setiBServiciosExternos(Double iBServiciosExternos) {
        this.iBServiciosExternos = iBServiciosExternos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getGananciaId() {
        return gananciaId;
    }

    public void setGananciaId(Integer gananciaId) {
        this.gananciaId = gananciaId;
    }

    public Double getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(Double totalGanancia) {
        this.totalGanancia = totalGanancia;
    }


}
