package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Curso} entity
 */
@Data
public class CursoDto implements Serializable {
    private final Integer id;
    private final String nombreCurso;
    private final String cdcCurso;
    private final Boolean estatusCurso;
    private final String periodoCurso;
    private final String codigoCruso;
    private final Integer anioCurso;
    private final String horaInicioCurso;
    private final String horaFinCurso;
    private final Integer tamanioCurso;
}