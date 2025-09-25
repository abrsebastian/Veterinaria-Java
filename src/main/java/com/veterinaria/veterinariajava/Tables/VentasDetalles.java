package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "ventas_detalles")

public class VentasDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Integer detalleId;

    @Column(name = "cantidad")
    private int cantidadProductoVendido;

    @Column(name = "precio_unitario")
    private double precioUnitarioPorVenta;

    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "fecha")
    @CreationTimestamp
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Productos productos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    private Ventas venta;

    public VentasDetalles() {
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public int getCantidadProductoVendido() {
        return cantidadProductoVendido;
    }

    public void setCantidadProductoVendido(int cantidadProductoVendido) {
        this.cantidadProductoVendido = cantidadProductoVendido;
    }

    public double getPrecioUnitarioPorVenta() {
        return precioUnitarioPorVenta;
    }

    public void setPrecioUnitarioPorVenta(double precioUnitarioPorVenta) {
        this.precioUnitarioPorVenta = precioUnitarioPorVenta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Ventas getVentas() {
        return venta;
    }

    public void setVentas(Ventas venta) {
        this.venta = venta;
    }
}
