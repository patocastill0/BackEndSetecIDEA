package com.setec.mvc.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import java.time.LocalDate;


@Entity
@Table(name = "clua")
public class Clua implements Serializable {
    @Id
    @Column(name = "id_clua", nullable = false, length = 250)
    private String id;

    @Column(name = "estado_clua", nullable = false, length = 50)
    private String estadoClua;

    @Column(name = "fecha_creacion_clua", nullable = false)
    private LocalDate fechaCreacionClua;

    @Column(name = "vigencia_clua", nullable = false, length = 50)
    private String vigenciaClua;

    @Column(name = "anio_afiliacion", nullable = false, length=20)
    private String anioAfiliacion;


    @OneToMany(mappedBy = "cluaTrabajador")
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstadoClua() {
        return estadoClua;
    }

    public void setEstadoClua(String estadoClua) {
        this.estadoClua = estadoClua;
    }

    public LocalDate getFechaCreacionClua() {
        return fechaCreacionClua;
    }

    public void setFechaCreacionClua(LocalDate fechaCreacionClua) {
        this.fechaCreacionClua = fechaCreacionClua;
    }

    public String getVigenciaClua() {
        return vigenciaClua;
    }
    public void setVigenciaClua(String vigenciaClua) {
        this.vigenciaClua = vigenciaClua;
    }

    public String getAnioAfiliacion() {return anioAfiliacion;}

    public void setAnioAfiliacion(String anioAfiliacion) {
        this.anioAfiliacion = anioAfiliacion;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}