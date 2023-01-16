package com.setec.mvc.dtos;

import com.setec.mvc.enums.GeneroType;
import com.setec.mvc.enums.TrabajadorType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Trabajador} entity
 */
@Data
public class TrabajadorDto implements Serializable {
    private final String id;
    private final String nombreTrabajador;
    private final String apellidopaTrabajador;
    private final String apellidomaTrabajador;
    private final GeneroType generoTrabajador;
    private final LocalDate fechanaTrabajador;
    private final String estadoCivilTrabajador;
    private final String telcelularTrabajador;
    private final String claveElectorTrabajador;
    private final String codigoPostalTrabajador;
    private final String calleTrabajador;
    private final String coloniaTrabajador;
    private final String telcasaTrabajador;
    private final String seccionTrabajador;
    private final String localidadTrabajador;
    private final String tipoSanguineoTrabajador;
    private final String correoElectronicoTrabajador;
    private final String instagramTrabajador;
    private final String facebookTrabajador;
    private final String twitterTrabajador;
    private final String folioTrabajador;
    private final RegionDto regionTrabajador;
    private final SectorDto sectorTrabajador;
    private final CdcDto cdcTrabajador;
    private final CargoDto cargoTrabajador;
    private final CluaDto cluaTrabajador;
    private final TrabajadorType tipoTrabajador;
    private final Boolean eliminarTrabajador;
    private final String urlimagenTrabajador;
    private final Set<CursoDto> cursos;
    private final UsuarioDto usuario;
}