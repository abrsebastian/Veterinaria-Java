package com.veterinaria.veterinariajava.Tables;

import com.veterinaria.veterinariajava.Models.TipoDeGasto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "gatos_fijos")
public class GastosFijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gasto_id")
    private Integer gastoFijoId;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_de_gasto")
    private TipoDeGasto tipoDeGasto;

    @Column(name="monto")
    private Double montoGasto;

    @Column(name = "fecha")
    @CreationTimestamp
    private LocalDateTime fecha;


    public  GastosFijos(){}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getGastoFijoId() {
        return gastoFijoId;
    }

    public void setGastoFijoId(Integer gastoFijoId) {
        this.gastoFijoId = gastoFijoId;
    }

    public TipoDeGasto getTipoDeGasto() {
        return tipoDeGasto;
    }

    public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
        this.tipoDeGasto = tipoDeGasto;
    }

    public Double getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(Double montoGasto) {
        this.montoGasto = montoGasto;
    }
}
