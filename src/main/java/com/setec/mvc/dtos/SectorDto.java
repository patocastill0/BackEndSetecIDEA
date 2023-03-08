package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Sector} entity
 */
@Data
public class SectorDto implements Serializable {
    private final Integer id;
    private final String nombreSector;
}