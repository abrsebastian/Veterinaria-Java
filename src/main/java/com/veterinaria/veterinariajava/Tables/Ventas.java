package com.veterinaria.veterinariajava.Tables;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")

public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Integer ventaId;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleados;

    @Column(name = "cantidad")
    private Long cantidadProductoVendido;

    @Column(name = "precio_unitario")
    private double precioUnitarioPorVenta;

    @Column(name = "precio_total")
    private double precioTotal;

    @Column(name = "comision")
    private double comisionPorVenta;

    @Column(name = "fecha")
    @CreationTimestamp
    private LocalDateTime fecha;

    public Ventas() {
    };

    public Ventas(Productos productos,
                  Empleados empleados,
                  Long cantidad,
                  double precioUnitarioPorVenta,
                  double comisionPorVenta) {
        this.productos = productos;
        this.empleados = empleados;
        this.cantidadProductoVendido = cantidad;
        this.precioUnitarioPorVenta = precioUnitarioPorVenta;
        this.precioTotal = precioUnitarioPorVenta * cantidad;
        this.comisionPorVenta = comisionPorVenta;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Long getCantidadProductoVendido() {
        return cantidadProductoVendido;
    }

    public void setCantidadProductoVendido(Long cantidadProductoVendido) {
        this.cantidadProductoVendido = cantidadProductoVendido;
    }

    public double getPrecioUnitarioPorVenta() {
        return precioUnitarioPorVenta;
    }

    public void setPrecioUnitarioPorVenta(double precioUnitarioPorVenta) {
        this.precioUnitarioPorVenta = precioUnitarioPorVenta;
    }

    public double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta(double comisionPorVenta) {
        this.comisionPorVenta = comisionPorVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
