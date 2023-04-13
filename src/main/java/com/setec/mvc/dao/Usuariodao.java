package com.setec.mvc.dao;

import com.setec.mvc.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Usuariodao extends JpaRepository<Usuario,Integer> {

    //public Optional<Usuario> findByUserNameUsuario(@Param("userNameUsuario")String userNameUsuario);

    public Usuario findByUserNameUsuario(@Param("userNameUsuario")String userNameUsuario);
}
