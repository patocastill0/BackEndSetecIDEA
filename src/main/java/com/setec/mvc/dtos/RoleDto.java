package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Integer id;
    private final String descripcionRol;
}