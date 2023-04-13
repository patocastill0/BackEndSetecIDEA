package com.setec.mvc.servicios;

import com.setec.mvc.dao.Regiondao;
import com.setec.mvc.dtos.RegionDto;
import com.setec.mvc.entidades.Region;
import com.setec.mvc.general.EntidadRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServicioImpl implements Crud<RegionDto>{

    @Autowired
    private Regiondao regiondao;

    @Override
    public RegionDto findById(String id) {
        Region region=null;
        RegionDto regionDto=null;
        int idParse=Integer.parseInt(id);
        if(regiondao.findById(idParse)!=null) {
            region=regiondao.findById(idParse).get();
            regionDto= new RegionDto(
                    region.getId(),
                    region.getNombreRegion());
        }
        return regionDto;
    }

    @Override
    public RegionDto save(RegionDto entity) {
        return null;
    }

    @Override
    public List<RegionDto> findAll() {
        List<Region>regiones=regiondao.findAll();
        List<RegionDto>regionDtos=new ArrayList<>();
        for(Region region:regiones)
            regionDtos.add(new RegionDto(
                    region.getId(),
                    region.getNombreRegion()));
        return regionDtos;
    }

    @Override
    public EntidadRespuesta<RegionDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<RegionDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public RegionDto update(RegionDto tipo, String id) {
        return null;
    }

    @Override
    public Object mapearEntity(RegionDto entidadDto) {
        return null;
    }
}
