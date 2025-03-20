package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
