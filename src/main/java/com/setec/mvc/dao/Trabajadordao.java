package com.setec.mvc.dao;

import com.setec.mvc.entidades.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trabajadordao extends JpaRepository<Trabajador,String> {
    List<Trabajador> findByTerm(
            @Param("id")String id,
            @Param("apellidomaTrabajador")String apellidomaTrabajador,
            @Param("apellidopaTrabajador")String apellidopaTrabajador,
            @Param("nombreTrabajador")String nombreTrabajador,
            @Param("nombreC")String nombreC);
    Trabajador findByFolio(@Param("folio")int folio);

    Trabajador findByFolioTrabajador(@Param("folioTrabajador")String folioTrabajador);

}
