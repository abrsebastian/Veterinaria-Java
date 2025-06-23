package com.veterinaria.veterinariajava.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDeServicio {
    INTERNO,
    EXTERNO;

    @JsonCreator
    public static TipoDeServicio fromString(String value){
        return value == null ? null : TipoDeServicio.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue(){
        return this.name();
    }
}
