package com.setec.mvc.dao;

import com.setec.mvc.entidades.Sector;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Sectordao extends AbstractJpaDAO<Sector> {
    @Override
    public Sector findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Sector> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Sector entity) {
        super.create(entity);
    }

    @Override
    public Sector update(Sector entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Sector entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
