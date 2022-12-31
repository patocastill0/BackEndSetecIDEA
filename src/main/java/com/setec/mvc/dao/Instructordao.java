package com.setec.mvc.dao;

import com.setec.mvc.entidades.Instructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Instructordao extends AbstractJpaDAO<Instructor> {
    @Override
    public Instructor findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Instructor> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Instructor entity) {
        super.create(entity);
    }

    @Override
    public Instructor update(Instructor entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Instructor entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
