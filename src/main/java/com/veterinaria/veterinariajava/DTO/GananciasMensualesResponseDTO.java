package com.veterinaria.veterinariajava.DTO;

public class GananciasMensualesResponseDTO {
    private String mes;
    private Double iBVentasTotal;
    private Double iBServiciosInternosTotal;
    private Double iBServiciosExternosTotal;
    private Double gastosFijosTotal;
    private Double gananciasLocal;

    public GananciasMensualesResponseDTO(String mes,
                                         Double iBVentasTotal,
                                         Double iBServiciosInternosTotal,
                                         Double iBServiciosExternosTotal,
                                         Double gastosFijosTotal,
                                         Double gananciasLocal) {
        this.mes = mes;
        this.iBVentasTotal = iBVentasTotal;
        this.iBServiciosInternosTotal = iBServiciosInternosTotal;
        this.iBServiciosExternosTotal = iBServiciosExternosTotal;
        this.gastosFijosTotal = gastosFijosTotal;
        this.gananciasLocal = gananciasLocal;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getiBVentasTotal() {
        return iBVentasTotal;
    }

    public void setiBVentasTotal(Double iBVentasTotal) {
        this.iBVentasTotal = iBVentasTotal;
    }

    public Double getiBServiciosInternosTotal() {
        return iBServiciosInternosTotal;
    }

    public void setiBServiciosInternosTotal(Double iBServiciosInternosTotal) {
        this.iBServiciosInternosTotal = iBServiciosInternosTotal;
    }

    public Double getiBServiciosExternosTotal() {
        return iBServiciosExternosTotal;
    }

    public void setiBServiciosExternosTotal(Double iBServiciosExternosTotal) {
        this.iBServiciosExternosTotal = iBServiciosExternosTotal;
    }

    public Double getGastosFijosTotal() {
        return gastosFijosTotal;
    }

    public void setGastosFijosTotal(Double gastosFijosTotal) {
        this.gastosFijosTotal = gastosFijosTotal;
    }

    public Double getGananciasLocal() {
        return gananciasLocal;
    }

    public void setGananciasLocal(Double gananciasLocal) {
        this.gananciasLocal = gananciasLocal;
    }
}


