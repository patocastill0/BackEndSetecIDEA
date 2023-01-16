package com.setec.mvc.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Usuario} entity
 */
@Data
public class UsuarioDto implements Serializable {
    private final Integer id;
    private final Boolean estadoUsuario;
    private final String userNameUsuario;
    private final String passwordUsuario;
    private final String tokenPasswordUsuario;
    private final Set<RoleDto> roles;
    private final TrabajadorDto trabajador;
}