package com.veterinaria.veterinariajava.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class VentasResponseDTO {

    private Integer ventaId;
    private String nombreEmpleado;
    private Double total;
    private List<VentasDetallesResponseDTO>detallesResponseDTOS;

    public VentasResponseDTO(Integer ventaId, LocalDateTime fecha, Integer empleadoId, String nombreEmpleado, double sum, List<VentasDetallesResponseDTO> detallesResponseDTOS) {
    }

    public VentasResponseDTO(Integer ventaId, String nombreEmpleado, Double total, List<VentasDetallesResponseDTO> detallesResponseDTOS) {
        this.ventaId = ventaId;
        this.nombreEmpleado = nombreEmpleado;
        this.total = total;
        this.detallesResponseDTOS = detallesResponseDTOS;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<VentasDetallesResponseDTO> getDetallesResponseDTOS() {
        return detallesResponseDTOS;
    }

    public void setDetallesResponseDTOS(List<VentasDetallesResponseDTO> detallesResponseDTOS) {
        this.detallesResponseDTOS = detallesResponseDTOS;
    }
}
