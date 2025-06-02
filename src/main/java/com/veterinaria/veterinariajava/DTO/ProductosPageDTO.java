package com.veterinaria.veterinariajava.DTO;

import java.util.List;

public class ProductosPageDTO {

    private List<ProductosResponseDTO> productosResponseDTOS;
    private int paginaActual;
    private int totalpaginas;
    private int totalElementos;

    public ProductosPageDTO(){}

    public ProductosPageDTO(List<ProductosResponseDTO> productos,
                            int paginaActual,
                            int totalpaginas,
                            int totalElementos){
        this.productosResponseDTOS = productos;
        this.paginaActual = paginaActual;
        this.totalpaginas = totalpaginas;
        this.totalElementos = totalElementos;
    }

    public List<ProductosResponseDTO> getProductosResponseDTOS() {
        return productosResponseDTOS;
    }

    public void setProductosResponseDTOS(List<ProductosResponseDTO> productosResponseDTOS) {
        this.productosResponseDTOS = productosResponseDTOS;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public int getTotalpaginas() {
        return totalpaginas;
    }

    public void setTotalpaginas(int totalpaginas) {
        this.totalpaginas = totalpaginas;
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(int totalElementos) {
        this.totalElementos = totalElementos;
    }
}
