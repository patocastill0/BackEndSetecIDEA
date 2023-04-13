package com.setec.mvc.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cdc")
public class Cdc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cdc", nullable = false)
    private Integer id;

    @Column(name = "nombre_cdc", nullable = false)
    private String nombreCdc;

    @OneToMany(mappedBy = "cdcTrabajador")
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCdc() {
        return nombreCdc;
    }

    public void setNombreCdc(String nombreCdc) {
        this.nombreCdc = nombreCdc;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}