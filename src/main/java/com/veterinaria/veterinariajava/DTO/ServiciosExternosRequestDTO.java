package com.veterinaria.veterinariajava.DTO;

public class ServiciosExternosRequestDTO {

    private String profesional;
    private Long numeroDeContacto;
    private String nombreEmpresa;
    private String tipoDeServicio;
    private Double costoServicioExterno;
    private Double porcentajeAgregado;

    public ServiciosExternosRequestDTO() {
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
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

}
