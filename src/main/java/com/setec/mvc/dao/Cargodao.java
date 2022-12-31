package com.setec.mvc.dao;

import com.setec.mvc.entidades.Cargo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Cargodao extends AbstractJpaDAO<Cargo> {
    @Override
    public Cargo findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Cargo> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Cargo entity) {
        super.create(entity);
    }

    @Override
    public Cargo update(Cargo entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Cargo entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
