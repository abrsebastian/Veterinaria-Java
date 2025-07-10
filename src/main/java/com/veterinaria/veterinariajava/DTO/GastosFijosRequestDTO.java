package com.veterinaria.veterinariajava.DTO;

import com.veterinaria.veterinariajava.Models.TipoDeGasto;

public class GastosFijosRequestDTO {
    private TipoDeGasto tipoDeGasto;
    private Double monto;

    public TipoDeGasto getTipoDeGasto() {
        return tipoDeGasto;
    }

    public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
        this.tipoDeGasto = tipoDeGasto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
