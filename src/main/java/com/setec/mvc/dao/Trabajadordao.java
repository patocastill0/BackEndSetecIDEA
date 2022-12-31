package com.setec.mvc.dao;

import com.setec.mvc.entidades.Trabajador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Trabajadordao extends AbstractJpaDAO<Trabajador> {
    @Override
    public Trabajador findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Trabajador> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Trabajador entity) {
        super.create(entity);
    }

    @Override
    public Trabajador update(Trabajador entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Trabajador entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
