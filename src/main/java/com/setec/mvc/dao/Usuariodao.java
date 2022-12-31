package com.setec.mvc.dao;

import com.setec.mvc.entidades.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Usuariodao extends AbstractJpaDAO<Usuario> {
    @Override
    public Usuario findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @Override
    public void create(Usuario entity) {
        super.create(entity);
    }

    @Override
    public Usuario update(Usuario entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Usuario entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }
}
