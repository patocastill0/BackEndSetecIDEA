package com.setec.mvc.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false)
    private Integer id;

    @Column(name = "nombre_curso", nullable = false, length = 250)
    private String nombreCurso;

    @Column(name = "cdc_curso", nullable = false, length = 250)
    private String cdcCurso;

    @Column(name = "estatus_curso", nullable = false)
    private Boolean estatusCurso = false;

    @Column(name = "periodo_curso", nullable = false, length = 250)
    private String periodoCurso;

    @Column(name = "codigo_cruso", nullable = false, length = 250)
    private String codigoCruso;

    @Column(name = "anio_curso", nullable = false)
    private Integer anioCurso;

    @Column(name = "hora_inicio_curso", nullable = false, length = 50)
    private String horaInicioCurso;

    @Column(name = "hora_fin_curso", nullable = false, length = 50)
    private String horaFinCurso;

    @Column(name = "tamanio_curso", nullable = false)
    private Integer tamanioCurso;

    @ManyToMany
    @JoinTable(name = "curso_instructor",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_instructor"))
    private Set<Instructor> instructors = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "trabajador_curso",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_trabajador"))
    private Set<Trabajador> trabajadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCdcCurso() {
        return cdcCurso;
    }

    public void setCdcCurso(String cdcCurso) {
        this.cdcCurso = cdcCurso;
    }

    public Boolean getEstatusCurso() {
        return estatusCurso;
    }

    public void setEstatusCurso(Boolean estatusCurso) {
        this.estatusCurso = estatusCurso;
    }

    public String getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(String periodoCurso) {
        this.periodoCurso = periodoCurso;
    }

    public String getCodigoCruso() {
        return codigoCruso;
    }

    public void setCodigoCruso(String codigoCruso) {
        this.codigoCruso = codigoCruso;
    }

    public Integer getAnioCurso() {
        return anioCurso;
    }

    public void setAnioCurso(Integer anioCurso) {
        this.anioCurso = anioCurso;
    }

    public String getHoraInicioCurso() {
        return horaInicioCurso;
    }

    public void setHoraInicioCurso(String horaInicioCurso) {
        this.horaInicioCurso = horaInicioCurso;
    }

    public String getHoraFinCurso() {
        return horaFinCurso;
    }

    public void setHoraFinCurso(String horaFinCurso) {
        this.horaFinCurso = horaFinCurso;
    }

    public Integer getTamanioCurso() {
        return tamanioCurso;
    }

    public void setTamanioCurso(Integer tamanioCurso) {
        this.tamanioCurso = tamanioCurso;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}