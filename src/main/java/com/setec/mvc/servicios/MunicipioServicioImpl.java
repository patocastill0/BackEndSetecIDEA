package com.setec.mvc.servicios;


import com.setec.mvc.dao.Municipiodao;
import com.setec.mvc.dtos.MunicipioDto;
import com.setec.mvc.entidades.Municipio;
import com.setec.mvc.general.EntidadRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipioServicioImpl implements Crud<MunicipioDto>{

    @Autowired
    private Municipiodao municipiodao;


    @Override
    public MunicipioDto findById(String id) {
        Municipio municipio=null;
        MunicipioDto municipioDto=null;
        int idParse=Integer.parseInt(id);
        if(municipiodao.findById(idParse)!=null) {
            municipio=municipiodao.findById(idParse);
            municipioDto= new MunicipioDto(
                    municipio.getId(),
                    municipio.getNombreMunicipio(),
                    municipio.getCabeceraMunicipal());
        }
        return municipioDto;
    }

    @Override
    public MunicipioDto save(MunicipioDto entity) {
        return null;
    }

    @Override
    public List<MunicipioDto> findAll() {
        List<Municipio>municipios=municipiodao.findAll();
        List<MunicipioDto>municipioDtos=new ArrayList<>();
        for(Municipio municipio:municipios)
            municipioDtos.add(new MunicipioDto(municipio.getId(),
                    municipio.getNombreMunicipio(),
                    municipio.getCabeceraMunicipal()));
        return municipioDtos;
    }
    public List<MunicipioDto> findByTerm(String term) {

        List<Municipio> listaMunicipios = municipiodao.findByTerminoMunicipio(term,term);
        List<MunicipioDto> listaMunicipiosDTO= new ArrayList<>();

        for (Municipio municipios : listaMunicipios) {

            listaMunicipiosDTO.add(new MunicipioDto(
                    municipios.getId(), municipios.getNombreMunicipio(),municipios.getCabeceraMunicipal()));
        }
        return listaMunicipiosDTO;
    }
    @Override
    public EntidadRespuesta<MunicipioDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<MunicipioDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public MunicipioDto update(MunicipioDto tipo, String id) {
        return null;
    }

    @Override
    public Object mapearEntity(MunicipioDto entidadDto) {
        return null;
    }
}
