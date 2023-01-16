package com.setec.mvc.servicios;

import com.setec.mvc.dao.Sectordao;
import com.setec.mvc.dtos.RoleDto;
import com.setec.mvc.dtos.SectorDto;
import com.setec.mvc.entidades.Role;
import com.setec.mvc.entidades.Sector;
import com.setec.mvc.general.EntidadRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorServicioImpl implements Crud<SectorDto>{

    @Autowired
    private Sectordao sectordao;

    @Override
    public SectorDto findById(String id) {
        Sector sector=null;
        SectorDto sectorDto=null;
        int idParse=Integer.parseInt(id);
        if(!sectordao.findById(idParse).isEmpty()) {
            sector=sectordao.findById(idParse).get();
            sectorDto= new SectorDto(
                    sector.getId(),
                    sector.getNombreSector());
        }
        return sectorDto;
    }

    @Override
    public SectorDto save(SectorDto entity) {
        return null;
    }

    @Override
    public List<SectorDto> findAll() {
        List<Sector>sectores=sectordao.findAll();
        List<SectorDto>sectorDtos=new ArrayList<>();
        for(Sector sector:sectores)
            sectorDtos.add(new SectorDto(
                    sector.getId(),
                    sector.getNombreSector()));
        return sectorDtos;
    }

    @Override
    public EntidadRespuesta<SectorDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<SectorDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public SectorDto update(SectorDto tipo, String id) {
        return null;
    }

    @Override
    public Object mapearEntity(SectorDto entidadDto) {
        return null;
    }
}
