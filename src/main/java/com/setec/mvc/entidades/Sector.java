package com.setec.mvc.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sector")
public class Sector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sector", nullable = false)
    private Integer id;

    @Column(name = "nombre_sector", nullable = false)
    private String nombreSector;

    @OneToMany(mappedBy = "sectorTrabajador")
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}