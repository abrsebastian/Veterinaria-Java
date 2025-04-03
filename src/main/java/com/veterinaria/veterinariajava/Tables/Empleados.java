package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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

    @Column(name = "sueldo_total", nullable = false)
    private Double sueldoTotal;
    
    @Column(name = "comisiones", nullable = true)
    private Double comisionesTotal = 0.0;
    
    @Column(name = "sueldo_final", nullable = true)
    private Double sueldoFinal = 0.0;

   
    
   // @PrePersist
   // @PreUpdate
   // private void calcularSueldoTotal(){
   //     this.sueldoTotal = this.sueldoPorHora * this.horasTrabajadas;
   // }
    //public void calcularSueldoFinal(){
        //this.sueldoFinal = this.sueldoTotal + this.comisionesTotal;
    //}

    public Double getComisiones() {
        return comisionesTotal;
    }

    public void setComisiones(double comisionesTotal) {
        this.comisionesTotal = comisionesTotal;
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

    public Double getComisionesTotal() {
        return comisionesTotal;
    }

    public void setComisionesTotal(double comisionesTotal) {
        this.comisionesTotal = comisionesTotal;
    }

}
