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

//    @ManyToOne
//    @JoinColumn(name = "producto_id", nullable = true)
//    private Productos productos;
//
//    @ManyToOne
//    @JoinColumn(name = "servicio_id", nullable = true)
//    private Servicios servicios;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha; 

    @Column(name = "ingresos_brutos_total", nullable = true)
    private double totalIngresosBrutos;

    @Column(name = "ib_ventas", nullable = true)
    private double iBVentas;

    @Column(name = "ib_servicios_internos", nullable = true)
    private double iBServiciosInternos;

    @Column(name = "ib_servicios_externos", nullable = true)
    private double iBServiciosExternos;

    @Column(name = "total_ganancia", nullable = true)
    private double totalGanancia;

    @Column(name = "gastos_fijos_total", nullable = true)
    private double gastosFijosTotal;

    @Column(name = "gananciasLocal", nullable = true)
    private double gananciasLocal;


    public Ganancias(){

    }

    public double getiBVentas() {
        return iBVentas;
    }

    public void setiBVentas(double iBVentas) {
        this.iBVentas = iBVentas;
    }

    public double getGastosFijosTotal() {
        return gastosFijosTotal;
    }

    public void setGastosFijosTotal(double gastosFijosTotal) {
        this.gastosFijosTotal = gastosFijosTotal;
    }

    public double getGananciasLocal() {
        return gananciasLocal;
    }

    public void setGananciasLocal(double gananciasLocal) {
        this.gananciasLocal = gananciasLocal;
    }

//    public Productos getProductos() {
//        return productos;
//    }
//
//    public void setProductos(Productos productos) {
//        this.productos = productos;
//    }
//
//    public Servicios getServicios() {
//        return servicios;
//    }
//
//    public void setServicios(Servicios servicios) {
//        this.servicios = servicios;
//    }

    public double getiBServiciosInternos() {
        return iBServiciosInternos;
    }

    public void setiBServiciosInternos(double iBServiciosInternos) {
        this.iBServiciosInternos = iBServiciosInternos;
    }

    public double getiBServiciosExternos() {
        return iBServiciosExternos;
    }

    public void setiBServiciosExternos(double iBServiciosExternos) {
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

//    public Productos getProducto() {
//        return productos;
//    }
//
//    public void setProducto(Productos productos) {
//        this.productos = productos;
//    }
//
//    public Servicios getServicio() {
//        return servicios;
//    }
//
//    public void setServicioId(Servicios servicios) {
//        this.servicios = servicios;
//    }

    public double getTotalIngresosBrutos() {
        return totalIngresosBrutos;
    }

    public void setTotalIngresosBrutos(double totalGanancias) {
        this.totalIngresosBrutos = totalGanancias;
    }

    public double getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(double totalGanancia) {
        this.totalGanancia = totalGanancia;
    }


}
