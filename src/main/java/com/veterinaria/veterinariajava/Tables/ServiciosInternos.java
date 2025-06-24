package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;

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

    public ServiciosInternos(){

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
