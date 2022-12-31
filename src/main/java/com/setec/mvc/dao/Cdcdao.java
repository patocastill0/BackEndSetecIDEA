package com.setec.mvc.dao;

import com.setec.mvc.entidades.Cdc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cdcdao extends JpaRepository<Cdc,Integer> {

}
