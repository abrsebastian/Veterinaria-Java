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
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_costo")
    private double precioCosto;

    @Column(name = "porcentaje_agregado", nullable = true)
    private double porcentajeAgregado;

    @Column(name = "precio_venta", nullable = true)
    private double precioVenta;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedores proveedor;

    public Productos(){}

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPorcentajeAgregado() {
        return porcentajeAgregado;
    }

    public void setPorcentajeAgregado(double porcentajeAgregado) {
        this.porcentajeAgregado = porcentajeAgregado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = (int) stock;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedores) {
        this.proveedor = proveedores;
    }

}
