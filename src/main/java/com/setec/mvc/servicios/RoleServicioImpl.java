package com.setec.mvc.servicios;

import com.setec.mvc.dao.Roledao;
import com.setec.mvc.dtos.RoleDto;
import com.setec.mvc.entidades.Role;
import com.setec.mvc.general.EntidadRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServicioImpl implements Crud<RoleDto>{

    @Autowired
    private Roledao roledao;

    @Override
    public RoleDto findById(String id) {
        Role role=null;
        RoleDto roleDto=null;
        int idParse=Integer.parseInt(id);
        if(roledao.findById(idParse)!=null) {
            role=roledao.findById(idParse).get();
            roleDto= new RoleDto(
                    role.getId(),
                    role.getDescripcionRol());
        }
        return roleDto;
    }

    @Override
    public RoleDto save(RoleDto entity) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role>roles=roledao.findAll();
        List<RoleDto>roleDtos=new ArrayList<>();
        for(Role role:roles)
            roleDtos.add(new RoleDto(
                    role.getId(),
                    role.getDescripcionRol()));
        return roleDtos;
    }

    @Override
    public EntidadRespuesta<RoleDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<RoleDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public RoleDto update(RoleDto tipo, String id) {
        return null;
    }

    @Override
    public Object mapearEntity(RoleDto entidadDto) {
        return null;
    }
}
