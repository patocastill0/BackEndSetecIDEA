package com.setec.mvc.entidades;

import com.setec.mvc.enums.GeneroType;
import com.setec.mvc.enums.TrabajadorType;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trabajador")
public class Trabajador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curp", nullable = false, length = 20)
    private String id;

    @Column(name = "nombre_trabajador", nullable = false, length = 200)
    private String nombreTrabajador;

    @Column(name = "apellidopa_trabajador", nullable = false, length = 200)
    private String apellidopaTrabajador;

    @Column(name = "apellidoma_trabajador", nullable = false, length = 200)
    private String apellidomaTrabajador;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero_trabajador", nullable = false)
    private GeneroType generoTrabajador;


    @Column(name = "fechana_trabajador", nullable = false)
    private LocalDate fechanaTrabajador;

    @Column(name = "estado_civil_trabajador", nullable = false, length = 100)
    private String estadoCivilTrabajador;

    @Column(name = "telcelular_trabajador", nullable = false, length = 10)
    private String telcelularTrabajador;

    @Column(name = "clave_elector_trabajador", nullable = false, length = 100)
    private String claveElectorTrabajador;

    @Column(name = "codigo_postal_trabajador", nullable = false, length = 5)
    private String codigoPostalTrabajador;

    @Column(name = "calle_trabajador", nullable = false, length = 400)
    private String calleTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "municipio_trabajador", nullable = false)
    private Municipio municipioTrabajador;

    @Column(name = "colonia_trabajador", nullable = false, length = 300)
    private String coloniaTrabajador;

    @Column(name = "telcasa_trabajador", nullable = false, length = 10)
    private String telcasaTrabajador;

    @Column(name = "seccion_trabajador", nullable = false, length = 200)
    private String seccionTrabajador;

    @Column(name = "localidad_trabajador", nullable = false, length = 200)
    private String localidadTrabajador;

    @Column(name = "tipo_sanguineo_trabajador", nullable = false, length = 45)
    private String tipoSanguineoTrabajador;

    @Column(name = "correo_electronico_trabajador", nullable = false, length = 100)
    private String correoElectronicoTrabajador;

    @Column(name = "instagram_trabajador", length = 45)
    private String instagramTrabajador;

    @Column(name = "facebook_trabajador", length = 45)
    private String facebookTrabajador;

    @Column(name = "twitter_trabajador", length = 45)
    private String twitterTrabajador;

    @Column(name = "folio_trabajador", nullable = false, length = 20)
    private String folioTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "region_trabajador", nullable = false)
    private Region regionTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "sector_trabajador", nullable = false)
    private Sector sectorTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cdc_trabajador", nullable = false)
    private Cdc cdcTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cargo_trabajador", nullable = false)
    private Cargo cargoTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "clua_trabajador", nullable = false)
    private Clua cluaTrabajador;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_trabajador", nullable = false)
    private TrabajadorType tipoTrabajador;

    @Column(name = "eliminar_trabajador")
    private Boolean eliminarTrabajador;

    @Column(name = "urlimagen_trabajador", nullable = false)
    private String urlimagenTrabajador;

    @ManyToMany
    @JoinTable(name = "trabajador_curso",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private Set<Curso> cursos = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidopaTrabajador() {
        return apellidopaTrabajador;
    }

    public void setApellidopaTrabajador(String apellidopaTrabajador) {
        this.apellidopaTrabajador = apellidopaTrabajador;
    }

    public String getApellidomaTrabajador() {
        return apellidomaTrabajador;
    }

    public void setApellidomaTrabajador(String apellidomaTrabajador) {
        this.apellidomaTrabajador = apellidomaTrabajador;
    }

    public GeneroType getGeneroTrabajador() {
        return generoTrabajador;
    }

    public void setGeneroTrabajador(GeneroType generoTrabajador) {
        this.generoTrabajador = generoTrabajador;
    }

    public LocalDate getFechanaTrabajador() {
        return fechanaTrabajador;
    }

    public void setFechanaTrabajador(LocalDate fechanaTrabajador) {
        this.fechanaTrabajador = fechanaTrabajador;
    }

    public String getEstadoCivilTrabajador() {
        return estadoCivilTrabajador;
    }

    public void setEstadoCivilTrabajador(String estadoCivilTrabajador) {
        this.estadoCivilTrabajador = estadoCivilTrabajador;
    }

    public String getTelcelularTrabajador() {
        return telcelularTrabajador;
    }

    public void setTelcelularTrabajador(String telcelularTrabajador) {
        this.telcelularTrabajador = telcelularTrabajador;
    }

    public String getClaveElectorTrabajador() {
        return claveElectorTrabajador;
    }

    public void setClaveElectorTrabajador(String claveElectorTrabajador) {
        this.claveElectorTrabajador = claveElectorTrabajador;
    }

    public String getCodigoPostalTrabajador() {
        return codigoPostalTrabajador;
    }

    public void setCodigoPostalTrabajador(String codigoPostalTrabajador) {
        this.codigoPostalTrabajador = codigoPostalTrabajador;
    }

    public String getCalleTrabajador() {
        return calleTrabajador;
    }

    public void setCalleTrabajador(String calleTrabajador) {
        this.calleTrabajador = calleTrabajador;
    }

    public Municipio getMunicipioTrabajador() {
        return municipioTrabajador;
    }

    public void setMunicipioTrabajador(Municipio municipioTrabajador) {
        this.municipioTrabajador = municipioTrabajador;
    }

    public String getColoniaTrabajador() {
        return coloniaTrabajador;
    }

    public void setColoniaTrabajador(String coloniaTrabajador) {
        this.coloniaTrabajador = coloniaTrabajador;
    }

    public String getTelcasaTrabajador() {
        return telcasaTrabajador;
    }

    public void setTelcasaTrabajador(String telcasaTrabajador) {
        this.telcasaTrabajador = telcasaTrabajador;
    }

    public String getSeccionTrabajador() {
        return seccionTrabajador;
    }

    public void setSeccionTrabajador(String seccionTrabajador) {
        this.seccionTrabajador = seccionTrabajador;
    }

    public String getLocalidadTrabajador() {
        return localidadTrabajador;
    }

    public void setLocalidadTrabajador(String localidadTrabajador) {
        this.localidadTrabajador = localidadTrabajador;
    }

    public String getTipoSanguineoTrabajador() {
        return tipoSanguineoTrabajador;
    }

    public void setTipoSanguineoTrabajador(String tipoSanguineoTrabajador) {
        this.tipoSanguineoTrabajador = tipoSanguineoTrabajador;
    }

    public String getCorreoElectronicoTrabajador() {
        return correoElectronicoTrabajador;
    }

    public void setCorreoElectronicoTrabajador(String correoElectronicoTrabajador) {
        this.correoElectronicoTrabajador = correoElectronicoTrabajador;
    }

    public String getInstagramTrabajador() {
        return instagramTrabajador;
    }

    public void setInstagramTrabajador(String instagramTrabajador) {
        this.instagramTrabajador = instagramTrabajador;
    }

    public String getFacebookTrabajador() {
        return facebookTrabajador;
    }

    public void setFacebookTrabajador(String facebookTrabajador) {
        this.facebookTrabajador = facebookTrabajador;
    }

    public String getTwitterTrabajador() {
        return twitterTrabajador;
    }

    public void setTwitterTrabajador(String twitterTrabajador) {
        this.twitterTrabajador = twitterTrabajador;
    }

    public String getFolioTrabajador() {
        return folioTrabajador;
    }

    public void setFolioTrabajador(String folioTrabajador) {
        this.folioTrabajador = folioTrabajador;
    }

    public Region getRegionTrabajador() {
        return regionTrabajador;
    }

    public void setRegionTrabajador(Region regionTrabajador) {
        this.regionTrabajador = regionTrabajador;
    }

    public Sector getSectorTrabajador() {
        return sectorTrabajador;
    }

    public void setSectorTrabajador(Sector sectorTrabajador) {
        this.sectorTrabajador = sectorTrabajador;
    }

    public Cdc getCdcTrabajador() {
        return cdcTrabajador;
    }

    public void setCdcTrabajador(Cdc cdcTrabajador) {
        this.cdcTrabajador = cdcTrabajador;
    }

    public Cargo getCargoTrabajador() {
        return cargoTrabajador;
    }

    public void setCargoTrabajador(Cargo cargoTrabajador) {
        this.cargoTrabajador = cargoTrabajador;
    }

    public Clua getCluaTrabajador() {
        return cluaTrabajador;
    }

    public void setCluaTrabajador(Clua cluaTrabajador) {
        this.cluaTrabajador = cluaTrabajador;
    }

    public TrabajadorType getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(TrabajadorType tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public Boolean getEliminarTrabajador() {
        return eliminarTrabajador;
    }

    public void setEliminarTrabajador(Boolean eliminarTrabajador) {
        this.eliminarTrabajador = eliminarTrabajador;
    }

    public String getUrlimagenTrabajador() {
        return urlimagenTrabajador;
    }

    public void setUrlimagenTrabajador(String urlimagenTrabajador) {
        this.urlimagenTrabajador = urlimagenTrabajador;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

}