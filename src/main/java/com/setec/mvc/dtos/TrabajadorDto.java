package com.setec.mvc.dtos;

import com.setec.mvc.enums.GeneroType;
import com.setec.mvc.enums.TrabajadorType;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Trabajador} entity
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class TrabajadorDto implements Serializable {
    private final String id;
    private final String nombreTrabajador;
    private final String apellidopaTrabajador;
    private final String apellidomaTrabajador;
    private final GeneroType generoTrabajador;
    private final Date fechanaTrabajador;
    private final String estadoCivilTrabajador;
    private final String telcelularTrabajador;
    private final String claveElectorTrabajador;
    private final String codigoPostalTrabajador;
    private final String calleTrabajador;
    private final String numeroCalle;
    private final MunicipioDto municipioTrabajador;
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
    private final boolean hasactanacimiento;
    private final boolean hascomprobante;
    private final boolean hascurp;
    private final boolean hasine;
    private final String anioAfiliacion;
    private final String idClua;


}