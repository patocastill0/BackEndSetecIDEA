package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Instructor} entity
 */
@Data
public class InstructorDto implements Serializable {
    private final String id;
    private final String nombreInstructor;
    private final String apellidopaInstructor;
    private final String apellidomaInstructor;
}