package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Municipio} entity
 */
@Data
public class MunicipioDto implements Serializable {
    private final Integer id;
    private final String nombreMunicipio;
    private final String cabeceraMunicipal;
}