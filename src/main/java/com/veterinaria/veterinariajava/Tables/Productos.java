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

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categorias;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedores proveedores;

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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = (int) stock;
    }

    public Categorias getCategoria() {
        return categorias;
    }

    public void setCategoria(Categorias categorias) {
        this.categorias = categorias;
    }

    public Proveedores getProveedor() {
        return proveedores;
    }

    public void setProveedor(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

}
