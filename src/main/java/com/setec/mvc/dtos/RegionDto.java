package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Region} entity
 */
@Data
public class RegionDto implements Serializable {
    private final Integer id;
    private final String nombreRegion;
}