package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas")

public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Integer ventaId;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleados;

    @Column(name = "precio_total")
    private double precioTotal;

    @Column(name = "comision")
    private double comisionPorVenta;

    @Column(name = "fecha")
    @CreationTimestamp
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<VentasDetalles> detallesList = new ArrayList<>();

    public Ventas() {
    };

    public Ventas(Productos productos,
                  Empleados empleados,
                  Long cantidad,
                  double precioUnitarioPorVenta,
                  double comisionPorVenta) {
        this.empleados = empleados;
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

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
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

    public List<VentasDetalles> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(List<VentasDetalles> detallesList) {
        this.detallesList = detallesList;
    }
}
