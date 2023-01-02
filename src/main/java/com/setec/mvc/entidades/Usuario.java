package com.setec.mvc.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "estado_usuario", nullable = false)
    private Boolean estadoUsuario = false;

    @Column(name = "user_name_usuario", nullable = false, length = 100)
    private String userNameUsuario;

    @Column(name = "password_usuario", nullable = true, length = 100)
    private String passwordUsuario;

    @Column(name = "token_password_usuario",  length = 300)
    private String tokenPasswordUsuario;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_roles"))
    private Set<Role> roles ;

    @JoinColumn(name = "trabajador", referencedColumnName = "id_curp", insertable = false, updatable = false)
    @OneToOne(optional = false,cascade = CascadeType.ALL)
    private Trabajador trabajador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getUserNameUsuario() {
        return userNameUsuario;
    }

    public void setUserNameUsuario(String userNameUsuario) {
        this.userNameUsuario = userNameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getTokenPasswordUsuario() {
        return tokenPasswordUsuario;
    }

    public void setTokenPasswordUsuario(String tokenPasswordUsuario) {
        this.tokenPasswordUsuario = tokenPasswordUsuario;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}