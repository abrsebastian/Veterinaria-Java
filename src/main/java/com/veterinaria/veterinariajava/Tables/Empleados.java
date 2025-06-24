package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

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

    @Column(name = "sueldo_total", nullable = true)
    private Double sueldoTotal = 0.0;
    
    @Column(name = "comisiones_ventas", nullable = true)
    private Double comisionesPorVentas = 0.0;

    @Column(name = "comisiones_servicios", nullable = true)
    private Double comisionPorServicio = 0.0;
    
    @Column(name = "sueldo_final", nullable = true)
    private Double sueldoFinal = 0.0;

    public Empleados (){
   
    }

    @PrePersist
    private void calcularSueldoTotal(){
        this.sueldoTotal = this.sueldoPorHora * this.horasTrabajadas;
    }

    public Double getComisionPorServicio() {
        return comisionPorServicio;
    }

    public void setComisionPorServicio(Double comisionPorServicio) {
        this.comisionPorServicio = comisionPorServicio;
    }

    public void set(Double comisionesTotal) {
        this.comisionesPorVentas = comisionesTotal;
    }

    public Double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
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

    public Double getComisionesPorVentas() {
        return comisionesPorVentas;
    }

    public void setComisionesPorVentas(double comisionesPorVentas) {
        this.comisionesPorVentas = comisionesPorVentas;
    }

    public void setTotalVentas(Ventas ventaGuardada) {
    }
}
