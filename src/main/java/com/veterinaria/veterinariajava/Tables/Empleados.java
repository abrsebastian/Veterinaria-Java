package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Integer empleadoId;

    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @Column(name = "tipo_empleado")
    private String tipoEmpleado;

    @Column(name = "horas_trabajadas")
    private double horasTrabajadas;

    @Column(name = "sueldo_por_hora")
    private double sueldoPorHora;

    @OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ventas> ventas = new ArrayList<>();

    @OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiciosInternos> serviciosInternos = new ArrayList<>();


    public Empleados() {

    }

    public List<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public void setTotalVentas(Ventas ventaGuardada) {
    }
}
