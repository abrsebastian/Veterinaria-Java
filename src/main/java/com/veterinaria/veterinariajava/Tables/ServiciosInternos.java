package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "servicios")

public class ServiciosInternos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Integer servicioId;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleados;

    @Column(name = "profesional")
    private String nombreDelProfesional;

    @Column(name ="nombre_servicio")
    private String nombreServicio;

    @Column(name = "precio_servicio")
    private double precioServicio;

    @Column(name = "porcentaje_comision_empleado")
    private Double porcentajeEmpleado;

    @Column(name = "precio_final")
    private Double precioFinal;

    @Column(name = "fecha")
    @CreationTimestamp
    private Date fecha;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    public ServiciosInternos(){

    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = fecha;
    }

    public Double getPorcentajeEmpleado() {
        return porcentajeEmpleado;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public void setPorcentajeEmpleado(Double porcentajeEmpleado) {
        this.porcentajeEmpleado = porcentajeEmpleado;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getNombreDelProfesional() {
        return nombreDelProfesional;
    }

    public void setNombreDelProfesional(String nombreDelProfesional) {
        this.nombreDelProfesional = nombreDelProfesional;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

}
