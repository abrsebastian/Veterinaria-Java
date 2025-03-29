package com.veterinaria.veterinariajava.Tables;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")

public class Ventas {
    double comisionCorrespondiente = 0.0;

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

    public Ventas() {
    };

    public Ventas(Productos productos, Empleados empleados, Long cantidad, double precioUnitarioPorVenta) {
        this.productos = productos;
        this.empleados = empleados;
        this.cantidadProductoVendido = cantidad;
        this.precioUnitarioPorVenta = precioUnitarioPorVenta;
        this.precioTotal = productos.getPrecioUnitario() * cantidad;
        this.comisionPorVenta = precioTotal * comisionCorrespondiente;

        if ("Veterinario".equalsIgnoreCase(empleados.getTipoEmpleado())) {
            comisionCorrespondiente = precioTotal * 0.15;
        } else if ("Recepcionista".equalsIgnoreCase(empleados.getTipoEmpleado())) {
            comisionCorrespondiente = precioTotal * 0.15;
        }

        empleados.setComisiones(empleados.getComisiones() + comisionCorrespondiente);
        empleados.calcularSueldoFinal();
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
    

}
