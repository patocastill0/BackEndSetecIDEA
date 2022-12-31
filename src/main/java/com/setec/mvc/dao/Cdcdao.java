package com.setec.mvc.dao;

import com.setec.mvc.entidades.Cdc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Cdcdao extends AbstractJpaDAO<Cdc> {
    @Override
    public Cdc findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Cdc> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Cdc entity) {
        super.create(entity);
    }

    @Override
    public Cdc update(Cdc entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Cdc entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
