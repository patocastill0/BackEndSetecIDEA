package com.setec.mvc.servicios;

import com.setec.mvc.dao.Cdcdao;
import com.setec.mvc.dao.Cluadao;
import com.setec.mvc.dtos.CdcDto;
import com.setec.mvc.dtos.CluaDto;
import com.setec.mvc.dtos.CursoDto;
import com.setec.mvc.entidades.Cdc;
import com.setec.mvc.entidades.Clua;
import com.setec.mvc.entidades.Curso;
import com.setec.mvc.general.EntidadRespuesta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CluaServicioImpl implements Crud<CluaDto>{

    @Autowired
    private Cluadao cluadao;

    @Override
    public CluaDto findById(String id) {
        CluaDto cluaDto=null;
        if(cluadao.findById(id)!=null) {
            Clua clua=cluadao.findById(id).get();
            cluaDto= new CluaDto(clua.getId(),
                    clua.getEstadoClua(),
                    clua.getFechaCreacionClua(),
                    clua.getVigenciaClua(),
                    clua.getAnioAfiliacion());
        }
        return cluaDto;
    }


    @Override
    public CluaDto save(CluaDto entity) {
        Clua clua=cluadao.save(mapearEntity(entity));
        return mapearDTO(clua);
    }

    @Override
    public List<CluaDto> findAll() {
        List<Clua>cluas=cluadao.findAll();
        List<CluaDto>cluaDtos=new ArrayList<>();
        for(Clua clua:cluas)
            cluaDtos.add(new CluaDto(clua.getId(),clua.getEstadoClua(),clua.getFechaCreacionClua(),clua.getVigenciaClua(),clua.getAnioAfiliacion()));
        return cluaDtos;
    }

    @Override
    public EntidadRespuesta<CluaDto> findAll(int numeroDePagina, int MedidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, MedidaDePagina);
        Page<Clua> cluaP=cluadao.findAll(pageable);
        List<Clua> listaClua =cluaP.getContent();
        List<CluaDto> lista= new ArrayList<>();
        for(Clua clua:listaClua){
            lista.add(new CluaDto(clua.getId(),
                    clua.getEstadoClua(),
                    clua.getFechaCreacionClua(),
                    clua.getVigenciaClua(),
                    clua.getAnioAfiliacion()));
        }
        EntidadRespuesta entidadrespuesta=new EntidadRespuesta();
        entidadrespuesta.setContenido(lista);
        entidadrespuesta.setNumeroPagina(cluaP.getNumber());
        entidadrespuesta.setMedidaPagina(cluaP.getSize());
        entidadrespuesta.setTotalElementos(cluaP.getTotalElements());
        entidadrespuesta.setTotalPaginas(cluaP.getTotalPages());
        entidadrespuesta.setUltima(cluaP.isLast());
        entidadrespuesta.setPrimera(cluaP.isFirst());

        return entidadrespuesta;

    }

    @Override
    public Page<CluaDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        if(cluadao.findById(id)!=null)
            cluadao.delete(cluadao.findById(id).get());
    }

    @Override
    public CluaDto update(CluaDto tipo, String id) {
        Clua cluaActualizado=null;
        if(cluadao.findById(id)!=null){
            Clua clua=cluadao.findById(id).get();
            clua.setId(tipo.getId());
            clua.setEstadoClua(tipo.getEstadoClua());
            clua.setFechaCreacionClua(tipo.getFechaCreacionClua());
            clua.setVigenciaClua(tipo.getVigenciaClua());
            cluaActualizado=cluadao.save(clua);
        }

        return mapearDTO(cluaActualizado);
    }

    @Override
    public Clua mapearEntity(CluaDto entidadDto) {
        Clua clua= new Clua();
        clua.setId(entidadDto.getId());
        clua.setEstadoClua(entidadDto.getEstadoClua());
        clua.setFechaCreacionClua(entidadDto.getFechaCreacionClua());
        clua.setVigenciaClua(entidadDto.getVigenciaClua());
        return clua;
    }

    public CluaDto mapearDTO(@NotNull Clua entidad) {

        return new CluaDto(entidad.getId(),entidad.getEstadoClua(),entidad.getFechaCreacionClua(),entidad.getVigenciaClua(),entidad.getAnioAfiliacion());
    }
}
