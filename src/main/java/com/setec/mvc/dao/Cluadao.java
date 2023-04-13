package com.setec.mvc.dao;

import com.setec.mvc.entidades.Clua;
import com.setec.mvc.entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cluadao extends JpaRepository<Clua,String> {

}
