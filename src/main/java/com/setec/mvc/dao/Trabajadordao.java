package com.setec.mvc.dao;

import com.setec.mvc.entidades.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trabajadordao extends JpaRepository<Trabajador,String> {

}
