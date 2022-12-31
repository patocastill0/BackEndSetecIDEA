package com.setec.mvc.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "municipios")
public class Municipio implements Serializable {
    @Id
    @Column(name = "id_municipio", nullable = false)
    private Integer id;

    @Column(name = "nombre_municipio", nullable = false, length = 800)
    private String nombreMunicipio;

    @Column(name = "cabecera_municipal", nullable = false, length = 800)
    private String cabeceraMunicipal;

    @OneToMany(mappedBy = "municipioTrabajador")
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getCabeceraMunicipal() {
        return cabeceraMunicipal;
    }

    public void setCabeceraMunicipal(String cabeceraMunicipal) {
        this.cabeceraMunicipal = cabeceraMunicipal;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}