package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Cdc} entity
 */
@Data
public class CdcDto implements Serializable {
    private final Integer id;
    private final String nombreCdc;
}