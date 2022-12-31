package com.setec.mvc.dao;

import com.setec.mvc.entidades.Municipio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Municipiodao extends AbstractJpaDAO<Municipio>{
    @Override
    public Municipio findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Municipio> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Municipio entity) {
        super.create(entity);
    }

    @Override
    public Municipio update(Municipio entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Municipio entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
