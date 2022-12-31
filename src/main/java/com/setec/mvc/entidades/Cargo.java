package com.setec.mvc.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", nullable = false)
    private Integer id;

    @Column(name = "nombre_cargo", nullable = false)
    private String nombreCargo;

    @OneToMany(mappedBy = "cargoTrabajador")
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}