package com.veterinaria.veterinariajava.DTO;

import com.veterinaria.veterinariajava.Models.TipoDeGasto;

import java.time.LocalDateTime;
import java.util.Date;

public class GastosFijosResponseDTO {
    private Integer gastoFijoId;
    private TipoDeGasto tipoDeGasto;
    private Double montoGastoFijo;
    private Date fecha;

    public GastosFijosResponseDTO(Integer gastoFijoId, TipoDeGasto tipoDeGasto, Double montoGasto, LocalDateTime fecha) {
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

    public Double getMontoGastoFijo() {
        return montoGastoFijo;
    }

    public void setMontoGastoFijo(Double montoGastoFijo) {
        this.montoGastoFijo = montoGastoFijo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
