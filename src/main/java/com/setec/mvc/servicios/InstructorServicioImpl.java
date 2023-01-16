package com.setec.mvc.servicios;

import com.setec.mvc.dao.Instructordao;
import com.setec.mvc.dtos.InstructorDto;
import com.setec.mvc.entidades.Instructor;
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
public class InstructorServicioImpl implements Crud<InstructorDto>{

    @Autowired
    private Instructordao instructordao;

    @Override
    public InstructorDto findById(String id) {
        InstructorDto instructorDto=null;
        if(!instructordao.findById(id).isEmpty()) {
            Instructor instructor=instructordao.findById(id).get();
            instructorDto= new InstructorDto(instructor.getId(),
                    instructor.getNombreInstructor(),
                    instructor.getApellidopaInstructor(),
                    instructor.getApellidomaInstructor());
        }
        return instructorDto;
    }

    @Override
    public InstructorDto save(InstructorDto entity) {
        Instructor instructor=instructordao.save(mapearEntity(entity));
        return mapearDTO(instructor);
    }

    @Override
    public List<InstructorDto> findAll() {
        List<Instructor>instructores=instructordao.findAll();
        List<InstructorDto>instructorDtos=new ArrayList<>();
        for(Instructor instructor:instructores)
            instructorDtos.add(new InstructorDto(instructor.getId(),
                    instructor.getNombreInstructor(),
                    instructor.getApellidopaInstructor(),
                    instructor.getApellidomaInstructor()));
        return instructorDtos;
    }

    @Override
    public EntidadRespuesta<InstructorDto> findAll(int numeroDePagina, int MedidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, MedidaDePagina);
        Page<Instructor> instructorP=instructordao.findAll(pageable);
        List<Instructor> listaInstructor =instructorP.getContent();
        List<InstructorDto> lista= new ArrayList<>();
        for(Instructor instructor:listaInstructor){
            lista.add(new InstructorDto(instructor.getId(),
                    instructor.getNombreInstructor(),
                    instructor.getApellidopaInstructor(),
                    instructor.getApellidomaInstructor()));
        }
        EntidadRespuesta entidadrespuesta=new EntidadRespuesta();
        entidadrespuesta.setContenido(lista);
        entidadrespuesta.setNumeroPagina(instructorP.getNumber());
        entidadrespuesta.setMedidaPagina(instructorP.getSize());
        entidadrespuesta.setTotalElementos(instructorP.getTotalElements());
        entidadrespuesta.setTotalPaginas(instructorP.getTotalPages());
        entidadrespuesta.setUltima(instructorP.isLast());
        entidadrespuesta.setPrimera(instructorP.isFirst());

        return entidadrespuesta;
    }

    @Override
    public Page<InstructorDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        if(!instructordao.findById(id).isEmpty())
            instructordao.delete(instructordao.findById(id).get());
    }

    @Override
    public InstructorDto update(InstructorDto tipo, String id) {
        Instructor instructorActualizado=null;
        if(!instructordao.findById(id).isEmpty()){
            Instructor instructor=instructordao.findById(id).get();
            instructor.setId(tipo.getId());
            instructor.setNombreInstructor(tipo.getNombreInstructor());
            instructor.setApellidopaInstructor(tipo.getApellidopaInstructor());
            instructor.setApellidomaInstructor(tipo.getApellidomaInstructor());
            instructorActualizado=instructordao.save(instructor);
        }

        return mapearDTO(instructorActualizado);

    }

    @Override
    public Instructor mapearEntity(InstructorDto entidadDto) {

        Instructor instructor= new Instructor();
        instructor.setId(entidadDto.getId());
        instructor.setNombreInstructor(entidadDto.getNombreInstructor());
        instructor.setApellidopaInstructor(entidadDto.getApellidopaInstructor());
        instructor.setApellidomaInstructor(entidadDto.getApellidomaInstructor());
        return instructor;
    }

    public InstructorDto mapearDTO(@NotNull Instructor entidad) {
        return new InstructorDto(entidad.getId(),
                entidad.getNombreInstructor(),
                entidad.getApellidopaInstructor(),
                entidad.getApellidomaInstructor());
    }
}
