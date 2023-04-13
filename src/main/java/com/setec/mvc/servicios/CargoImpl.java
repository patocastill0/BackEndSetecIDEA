package com.setec.mvc.servicios;

import com.setec.mvc.dao.Cargodao;
import com.setec.mvc.dtos.CargoDto;
import com.setec.mvc.entidades.Cargo;
import com.setec.mvc.general.EntidadRespuesta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CargoImpl implements Crud<CargoDto>{

    @Autowired
    private Cargodao cargoDao;

    @Override
    public CargoDto findById(String id) {
        return null;
    }
    public CargoDto findById(int id) {
        Cargo cargo=null;
        CargoDto cargoDto=null;
        if(cargoDao.findById(id)!=null) {
            cargo=cargoDao.findById(id);
            cargoDto= new CargoDto(cargo.getId(),cargo.getNombreCargo());
        }
        return cargoDto;
    }

    @Override
    public CargoDto save(CargoDto entity) {
        Cargo cargo=cargoDao.save(mapearEntity(entity));
        return mapearDTO(cargo) ;
    }

    @Override
    public List<CargoDto> findAll() {
        List<Cargo>cargos=cargoDao.findAll();
        List<CargoDto>cargosDto=new ArrayList<>();
        for(Cargo cargo:cargos)
            cargosDto.add(new CargoDto(cargo.getId(),cargo.getNombreCargo()));
        return cargosDto;
    }

    @Override
    public EntidadRespuesta<CargoDto> findAll(int numeroDePagina, int MedidaDePagina) {
        return null;
    }

    @Override
    public Page<CargoDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public void delete(int id) {
        if(cargoDao.findById(id)!=null)
            cargoDao.delete(cargoDao.findById(id));
    }

    @Override
    public CargoDto update(CargoDto tipo, String id) {
        return null;
    }

    public CargoDto update(CargoDto tipo, int id) {

        Cargo cargoActualizado=null;
        if(cargoDao.findById(id)!=null){
            Cargo cargo=cargoDao.findById(id);
            cargo.setId(tipo.getId());
            cargo.setNombreCargo(tipo.getNombreCargo());
            cargoActualizado=cargoDao.save(cargo);
        }

        return mapearDTO(cargoActualizado);
    }

    @Override
    public Cargo mapearEntity(CargoDto entidadDto) {
        Cargo cargo= new Cargo();
        //cargo.setId(entidadDto.getId());
        cargo.setNombreCargo(entidadDto.getNombreCargo());
        return cargo;
    }

    public CargoDto mapearDTO(@NotNull Cargo entidad) {
        return new CargoDto(entidad.getId(),entidad.getNombreCargo());
    }
}
