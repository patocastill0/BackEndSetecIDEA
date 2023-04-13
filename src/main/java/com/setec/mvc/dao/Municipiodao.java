package com.setec.mvc.dao;

import com.setec.mvc.entidades.Cargo;
import com.setec.mvc.entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import java.util.List;

@Repository
public interface Municipiodao extends JpaRepository<Municipio,Integer> {
    @Query("SELECT m FROM Municipio m WHERE UPPER(m.nombreMunicipio) like CONCAT(UPPER(:nombreMunicipio),'%') or UPPER(m.id) like CONCAT(UPPER(:id),'%')")
    List<Municipio> findByTerminoMunicipio(
            @Param("nombreMunicipio")String nombremunicipio,
            @Param("id")String id
    );
    public Municipio findById(int id);
}
