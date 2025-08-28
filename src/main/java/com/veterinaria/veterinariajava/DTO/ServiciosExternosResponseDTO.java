package com.veterinaria.veterinariajava.DTO;

public class ServiciosExternosResponseDTO {

    private Integer servicioExternoId;
    private String profesional;
    private Long numeroDeContacto;
    private String nombreEmpresa;
    private String tipoDeServicio;
    private Double costoServicioExterno;
    private Double porcentajeAgregado;
    private Double precioFinal;
    private Double comisionLocal;

    public ServiciosExternosResponseDTO() {
    }

    public Double getComisionLocal() {
        return comisionLocal;
    }

    public void setComisionLocal(Double comisionLocal) {
        this.comisionLocal = comisionLocal;
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    public Integer getServicioExternoId() {
        return servicioExternoId;
    }

    public void setServicioExternoId(Integer servicioExternoId) {
        this.servicioExternoId = servicioExternoId;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public Long getNumeroDeContacto() {
        return numeroDeContacto;
    }

    public void setNumeroDeContacto(Long numeroDeContacto) {
        this.numeroDeContacto = numeroDeContacto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Double getCostoServicioExterno() {
        return costoServicioExterno;
    }

    public void setCostoServicioExterno(Double costoServicioExterno) {
        this.costoServicioExterno = costoServicioExterno;
    }

    public Double getPorcentajeAgregado() {
        return porcentajeAgregado;
    }

    public void setPorcentajeAgregado(Double porcentajeAgregado) {
        this.porcentajeAgregado = porcentajeAgregado;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
