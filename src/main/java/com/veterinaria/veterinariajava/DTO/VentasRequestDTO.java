package com.veterinaria.veterinariajava.DTO;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;

import java.util.List;

public class VentasRequestDTO {

    @NotNull(message = "El ID del empleado no puede ser nulo")
    private Integer empleadoId;

    private List<ProductosVentaDTO> productos;

    @Data
    public static  class ProductosVentaDTO{
        private Integer productoId;
        private Integer cantidad;
    }


}
