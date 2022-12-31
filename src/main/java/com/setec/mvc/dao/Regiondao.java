package com.setec.mvc.dao;

import com.setec.mvc.entidades.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Regiondao extends AbstractJpaDAO<Region> {
    @Override
    public Region findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Region> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Region entity) {
        super.create(entity);
    }

    @Override
    public Region update(Region entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Region entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
