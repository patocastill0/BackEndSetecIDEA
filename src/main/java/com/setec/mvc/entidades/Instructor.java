package com.setec.mvc.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {
    @Id
    @Column(name = "curp_instructor", nullable = false, length = 20)
    private String id;

    @Column(name = "nombre_instructor", nullable = false, length = 250)
    private String nombreInstructor;

    @Column(name = "apellidopa_instructor", nullable = false, length = 250)
    private String apellidopaInstructor;

    @Column(name = "apellidoma_instructor", nullable = false, length = 250)
    private String apellidomaInstructor;

    @ManyToMany
    @JoinTable(name = "curso_instructor",
            joinColumns = @JoinColumn(name = "id_instructor"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private Set<Curso> cursos = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    public String getApellidopaInstructor() {
        return apellidopaInstructor;
    }

    public void setApellidopaInstructor(String apellidopaInstructor) {
        this.apellidopaInstructor = apellidopaInstructor;
    }

    public String getApellidomaInstructor() {
        return apellidomaInstructor;
    }

    public void setApellidomaInstructor(String apellidomaInstructor) {
        this.apellidomaInstructor = apellidomaInstructor;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

}