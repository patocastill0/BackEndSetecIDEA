package com.setec.mvc.dao;

import com.setec.mvc.entidades.Clua;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Cluadao extends AbstractJpaDAO<Clua> {
    @Override
    public Clua findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Clua> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Clua entity) {
        super.create(entity);
    }

    @Override
    public Clua update(Clua entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Clua entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
