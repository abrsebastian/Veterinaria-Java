package com.veterinaria.veterinariajava.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDeGasto {
    LUZ,
    ALQUILER,
    INTERNET,
    SUELDOS;

    @JsonCreator
    public static TipoDeGasto fromString(String value){
        return value == null ? null : TipoDeGasto.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue(){
        return this.name();
    }
}
