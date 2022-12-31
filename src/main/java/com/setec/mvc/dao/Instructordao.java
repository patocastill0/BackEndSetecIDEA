package com.setec.mvc.dao;

import com.setec.mvc.entidades.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Instructordao extends JpaRepository<Instructor,String> {

}
