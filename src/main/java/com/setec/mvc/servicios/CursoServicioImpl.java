package com.setec.mvc.servicios;


import com.setec.mvc.dao.Cursodao;
import com.setec.mvc.dtos.CursoDto;
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
public class CursoServicioImpl implements Crud<CursoDto>{

    @Autowired
    private Cursodao cursodao;
    @Override
    public CursoDto findById(String id) {
        CursoDto cursoDto=null;
        if(!cursodao.findById(Integer.parseInt(id)).isEmpty()) {
            Curso curso=cursodao.findById(Integer.parseInt(id)).get();
            cursoDto= new CursoDto(curso.getId(),
                    curso.getNombreCurso(),
                    curso.getCdcCurso(),
                    curso.getEstatusCurso(),
                    curso.getPeriodoCurso(),
                    curso.getCodigoCruso(),
                    curso.getAnioCurso(),
                    curso.getHoraInicioCurso(),
                    curso.getHoraFinCurso(),
                    curso.getTamanioCurso());
        }
        return cursoDto;
    }

    @Override
    public CursoDto save(CursoDto entity) {
        Curso curso=cursodao.save(mapearEntity(entity));
        return mapearDTO(curso);
    }

    @Override
    public List<CursoDto> findAll() {
        List<Curso>cursos=cursodao.findAll();
        List<CursoDto>cursoDtos=new ArrayList<>();
        for(Curso curso:cursos)
            cursoDtos.add(new CursoDto(curso.getId(),
                    curso.getNombreCurso(),
                    curso.getCdcCurso(),
                    curso.getEstatusCurso(),
                    curso.getPeriodoCurso(),
                    curso.getCodigoCruso(),
                    curso.getAnioCurso(),
                    curso.getHoraInicioCurso(),
                    curso.getHoraFinCurso(),
                    curso.getTamanioCurso()));
        return cursoDtos;
    }

    @Override
    public EntidadRespuesta<CursoDto> findAll(int numeroDePagina, int MedidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, MedidaDePagina);
        Page<Curso> cursosP=cursodao.findAll(pageable);
        List<Curso> listaCursos =cursosP.getContent();
        List<CursoDto> lista= new ArrayList<>();
        for(Curso curso:listaCursos){
            lista.add(new CursoDto(curso.getId(),
                    curso.getNombreCurso(),
                    curso.getCdcCurso(),
                    curso.getEstatusCurso(),
                    curso.getPeriodoCurso(),
                    curso.getCodigoCruso(),
                    curso.getAnioCurso(),
                    curso.getHoraInicioCurso(),
                    curso.getHoraFinCurso(),
                    curso.getTamanioCurso()));
        }
        EntidadRespuesta entidadrespuesta=new EntidadRespuesta();
        entidadrespuesta.setContenido(lista);
        entidadrespuesta.setNumeroPagina(cursosP.getNumber());
        entidadrespuesta.setMedidaPagina(cursosP.getSize());
        entidadrespuesta.setTotalElementos(cursosP.getTotalElements());
        entidadrespuesta.setTotalPaginas(cursosP.getTotalPages());
        entidadrespuesta.setUltima(cursosP.isLast());
        entidadrespuesta.setPrimera(cursosP.isFirst());

        return entidadrespuesta;
    }

    @Override
    public Page<CursoDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        int identero=Integer.parseInt(id);
        if(!cursodao.findById(identero).isEmpty())
            cursodao.delete(cursodao.findById(identero).get());
    }

    @Override
    public CursoDto update(CursoDto tipo, String id) {
        Curso cursoActualizado=null;
        int identero=Integer.parseInt(id);
        if(!cursodao.findById(identero).isEmpty()){
            Curso curso=cursodao.findById(identero).get();
            curso.setId(tipo.getId());
            curso.setNombreCurso(tipo.getNombreCurso());
            curso.setCdcCurso(tipo.getCdcCurso());
            curso.setEstatusCurso(tipo.getEstatusCurso());
            curso.setPeriodoCurso(tipo.getPeriodoCurso());
            curso.setPeriodoCurso(tipo.getPeriodoCurso());
            curso.setCodigoCruso(tipo.getCodigoCruso());
            curso.setAnioCurso(tipo.getAnioCurso());
            curso.setHoraInicioCurso(tipo.getHoraInicioCurso());
            curso.setHoraFinCurso(tipo.getHoraFinCurso());
            curso.setTamanioCurso(tipo.getTamanioCurso());
            cursoActualizado=cursodao.save(curso);
        }

        return mapearDTO(cursoActualizado);
    }

    @Override
    public Curso mapearEntity(CursoDto entidadDto) {
        Curso curso= new Curso();
        //curso.setId(entidadDto.getId());
        curso.setNombreCurso(entidadDto.getNombreCurso());
        curso.setCdcCurso(entidadDto.getCdcCurso());
        curso.setEstatusCurso(entidadDto.getEstatusCurso());
        curso.setPeriodoCurso(entidadDto.getPeriodoCurso());
        curso.setPeriodoCurso(entidadDto.getPeriodoCurso());
        curso.setCodigoCruso(entidadDto.getCodigoCruso());
        curso.setAnioCurso(entidadDto.getAnioCurso());
        curso.setHoraInicioCurso(entidadDto.getHoraInicioCurso());
        curso.setHoraFinCurso(entidadDto.getHoraFinCurso());
        curso.setTamanioCurso(entidadDto.getTamanioCurso());
        return curso;
    }

    public CursoDto mapearDTO(@NotNull Curso entidad) {

        return new CursoDto(entidad.getId(),
                entidad.getNombreCurso(),
                entidad.getCdcCurso(),
                entidad.getEstatusCurso(),
                entidad.getPeriodoCurso(),
                entidad.getCodigoCruso(),
                entidad.getAnioCurso(),
                entidad.getHoraInicioCurso(),
                entidad.getHoraFinCurso(),
                entidad.getTamanioCurso());
    }
}
