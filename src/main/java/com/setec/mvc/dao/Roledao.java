package com.setec.mvc.dao;


import com.setec.mvc.entidades.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Roledao extends AbstractJpaDAO<Role> {
    @Override
    public Role findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Role> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Role entity) {
        super.create(entity);
    }

    @Override
    public Role update(Role entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Role entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
