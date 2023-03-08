package com.setec.mvc.servicios;

import com.setec.mvc.dao.Cdcdao;
import com.setec.mvc.dtos.CdcDto;
import com.setec.mvc.entidades.Cdc;
import com.setec.mvc.general.EntidadRespuesta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CdcServicioImpl implements Crud<CdcDto>{

    @Autowired
    private Cdcdao cdcdao;

    @Override
    public CdcDto findById(String id) {
        return null;
    }

    public CdcDto findById(int id) {
        CdcDto cdcDto=null;
        if(!cdcdao.findById(id).isEmpty()) {
            Cdc cdc=cdcdao.findById(id).get();
            cdcDto= new CdcDto(cdc.getId(),cdc.getNombreCdc());
        }
        return cdcDto;
    }

    @Override
    public CdcDto save(CdcDto entity) {
        Cdc cdc=cdcdao.save(mapearEntity(entity));
        return mapearDTO(cdc);
    }

    @Override
    public List<CdcDto> findAll() {
        List<Cdc>cdcs=cdcdao.findAll();
        List<CdcDto>cdcDtos=new ArrayList<>();
        for(Cdc cdc:cdcs)
            cdcDtos.add(new CdcDto(cdc.getId(),cdc.getNombreCdc()));
        return cdcDtos;
    }

    @Override
    public EntidadRespuesta<CdcDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<CdcDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public void delete(int id) {
        if(!cdcdao.findById(id).isEmpty())
            cdcdao.delete(cdcdao.findById(id).get());
    }

    @Override
    public CdcDto update(CdcDto tipo, String id) {
        return null;
    }

    public CdcDto update(CdcDto tipo, int id) {

        Cdc cdcActualizado=null;
        if(!cdcdao.findById(id).isEmpty()){
            Cdc cdc=cdcdao.findById(id).get();
            cdc.setId(tipo.getId());
            cdc.setNombreCdc(tipo.getNombreCdc());
            cdcActualizado=cdcdao.save(cdc);
        }

        return mapearDTO(cdcActualizado);
    }

    @Override
    public Cdc mapearEntity(CdcDto entidadDto) {
        Cdc cdc= new Cdc();
        cdc.setNombreCdc(entidadDto.getNombreCdc());
        return cdc;
    }

    public CdcDto mapearDTO(@NotNull Cdc entidad) {

        return new CdcDto(entidad.getId(),entidad.getNombreCdc());
    }
}
