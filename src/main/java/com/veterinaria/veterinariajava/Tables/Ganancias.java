package com.veterinaria.veterinariajava.Tables;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = true)
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = true)
    private Servicios servicios;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha; 

    @Column(name = "total_ingresos", nullable = true)
    private double totalIngresos;

    @Column(name = "total_ganancia", nullable = true)
    private double totalGanancia;

    public Ganancias(){

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

    public Productos getProducto() {
        return productos;
    }

    public void setProducto(Productos productos) {
        this.productos = productos;
    }

    public Servicios getServicio() {
        return servicios;
    }

    public void setServicioId(Servicios servicios) {
        this.servicios = servicios;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalGanancias) {
        this.totalIngresos = totalGanancias;
    }

    public double getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(double totalGanancia) {
        this.totalGanancia = totalGanancia;
    }


}
