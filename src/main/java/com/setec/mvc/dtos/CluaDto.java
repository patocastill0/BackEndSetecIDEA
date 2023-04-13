package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Clua} entity
 */
@Data
public class CluaDto implements Serializable {
    private final String id;
    private final String estadoClua;
    private final LocalDate fechaCreacionClua;
    private final String vigenciaClua;
    private final String anioAfiliacion;


}