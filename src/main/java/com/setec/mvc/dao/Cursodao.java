package com.setec.mvc.dao;

import com.setec.mvc.entidades.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Cursodao extends AbstractJpaDAO<Curso> {
    @Override
    public Curso findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Curso> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Curso entity) {
        super.create(entity);
    }

    @Override
    public Curso update(Curso entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Curso entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
