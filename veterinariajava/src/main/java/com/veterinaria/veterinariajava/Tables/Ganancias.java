package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ganancias")

public class Ganancias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ganancia_id")
    private Integer gananciaId;

    @Column(name = "producto_id", nullable = true)
    private int productoId;

    @Column(name = "servicio_id", nullable = true)
    private int servicioId;

    @Column(name = "total_ingresos")
    private double totalGanancias;

    @Column(name = "total_ganancia")
    private double totalGanancia;

    public Integer getGananciaId() {
        return gananciaId;
    }

    public void setGananciaId(Integer gananciaId) {
        this.gananciaId = gananciaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getServicioId() {
        return servicioId;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }

    public double getTotalGanancias() {
        return totalGanancias;
    }

    public void setTotalGanancias(double totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    public double getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(double totalGanancia) {
        this.totalGanancia = totalGanancia;
    }

    
}
