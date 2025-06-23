package com.veterinaria.veterinariajava.Tables;

import jakarta.persistence.*;

@Entity
@Table(name = "gatos_fijos")
public class GastosFijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gasto_id")
    private Integer gastoFijoId;

    @Column(name="tipo_de_gasto")
    private String tipoDeGasto;

    @Column(name="monto")
    private Double montoGasto;


    public  GastosFijos(){}

    public Integer getGastoFijoId() {
        return gastoFijoId;
    }

    public void setGastoFijoId(Integer gastoFijoId) {
        this.gastoFijoId = gastoFijoId;
    }

    public String getTipoDeGasto() {
        return tipoDeGasto;
    }

    public void setTipoDeGasto(String tipoDeGasto) {
        this.tipoDeGasto = tipoDeGasto;
    }

    public Double getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(Double montoGasto) {
        this.montoGasto = montoGasto;
    }
}
