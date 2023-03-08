package com.setec.mvc.servicios;

import com.setec.mvc.dao.*;
import com.setec.mvc.dtos.*;
import com.setec.mvc.entidades.*;
import com.setec.mvc.enums.TrabajadorType;
import com.setec.mvc.general.EntidadRespuesta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrabajadorServicioImpl implements Crud<TrabajadorDto>{

    @Autowired
    private Trabajadordao trabajadordao;

    @Autowired
    private Municipiodao municipiodao;

    @Autowired
    private Regiondao regiondao;

    @Autowired
    private Sectordao sectordao;

    @Autowired
    private Cdcdao cdcdao;

    @Autowired
    private Cargodao cargodao;

    @Autowired
    private Cluadao cluadao;

    @Override
    public TrabajadorDto findById(String id) {
        TrabajadorDto trabajadorDto=null;
        if(!trabajadordao.findById(id).isEmpty()) {
            Trabajador trabajador=trabajadordao.findById(id).get();
            trabajadorDto= mapearDTO(trabajador);
        }
        return trabajadorDto;
    }

    @Override
    public TrabajadorDto save(TrabajadorDto entity) {
        Trabajador trabajador=trabajadordao.save(mapearEntity(entity));
        return mapearDTO(trabajador);
    }

    @Override
    public List<TrabajadorDto> findAll() {
        List<Trabajador>trabajadores=trabajadordao.findAll();
        List<TrabajadorDto>trabajadorDtos=new ArrayList<>();
        for(Trabajador trabajador:trabajadores)
            trabajadorDtos.add(mapearDTO(trabajador));
        return trabajadorDtos;
    }

    @Override
    public EntidadRespuesta<TrabajadorDto> findAll(int numeroDePagina, int MedidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, MedidaDePagina);
        Page<Trabajador> trabajadorP=trabajadordao.findAll(pageable);
        List<Trabajador> listaTrabajador =trabajadorP.getContent();
        List<TrabajadorDto> lista= new ArrayList<>();
        for(Trabajador trabajador:listaTrabajador){
            lista.add(mapearDTO(trabajador));
        }
        EntidadRespuesta entidadrespuesta=new EntidadRespuesta();
        entidadrespuesta.setContenido(lista);
        entidadrespuesta.setNumeroPagina(trabajadorP.getNumber());
        entidadrespuesta.setMedidaPagina(trabajadorP.getSize());
        entidadrespuesta.setTotalElementos(trabajadorP.getTotalElements());
        entidadrespuesta.setTotalPaginas(trabajadorP.getTotalPages());
        entidadrespuesta.setUltima(trabajadorP.isLast());
        entidadrespuesta.setPrimera(trabajadorP.isFirst());

        return entidadrespuesta;
    }

    @Override
    public Page<TrabajadorDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        if(!trabajadordao.findById(id).isEmpty())
            trabajadordao.delete(trabajadordao.findById(id).get());
    }

    @Override
    public TrabajadorDto update(TrabajadorDto tipo, String id) {
        return null;
    }

    @Override
    public Trabajador mapearEntity(TrabajadorDto entidadDto) {
        Trabajador trabajador= new Trabajador();
        trabajador.setId(entidadDto.getId());
        trabajador.setNombreTrabajador(entidadDto.getNombreTrabajador());
        trabajador.setApellidopaTrabajador(entidadDto.getApellidopaTrabajador());
        trabajador.setApellidomaTrabajador(entidadDto.getApellidomaTrabajador());
        trabajador.setGeneroTrabajador(entidadDto.getGeneroTrabajador());
        trabajador.setFechanaTrabajador(entidadDto.getFechanaTrabajador());
        trabajador.setEstadoCivilTrabajador(entidadDto.getEstadoCivilTrabajador());
        trabajador.setTelcelularTrabajador(entidadDto.getTelcelularTrabajador());
        trabajador.setClaveElectorTrabajador(entidadDto.getClaveElectorTrabajador());
        trabajador.setCodigoPostalTrabajador(entidadDto.getCodigoPostalTrabajador());
        trabajador.setCalleTrabajador(entidadDto.getCalleTrabajador());
        Municipio municipio =municipiodao.findById(entidadDto.getMunicipioTrabajador().getId()).orElse(null);
        trabajador.setMunicipioTrabajador(municipio);
        trabajador.setColoniaTrabajador(entidadDto.getColoniaTrabajador());
        trabajador.setTelcasaTrabajador(entidadDto.getTelcasaTrabajador());
        trabajador.setSeccionTrabajador(entidadDto.getSeccionTrabajador());
        trabajador.setLocalidadTrabajador(entidadDto.getLocalidadTrabajador());
        trabajador.setTipoSanguineoTrabajador(entidadDto.getTipoSanguineoTrabajador());
        trabajador.setCorreoElectronicoTrabajador(entidadDto.getCorreoElectronicoTrabajador());
        trabajador.setInstagramTrabajador(entidadDto.getInstagramTrabajador());
        trabajador.setFacebookTrabajador(entidadDto.getFacebookTrabajador());
        trabajador.setTwitterTrabajador(entidadDto.getTwitterTrabajador());
        trabajador.setFolioTrabajador(entidadDto.getFolioTrabajador());
        Region region=regiondao.findById(entidadDto.getRegionTrabajador().getId()).orElse(null);
        trabajador.setRegionTrabajador(region);
        Sector sector=sectordao.findById(entidadDto.getSectorTrabajador().getId()).orElse(null);
        trabajador.setSectorTrabajador(sector);
        Cdc cdc=cdcdao.findById(entidadDto.getSectorTrabajador().getId()).orElse(null);
        trabajador.setCdcTrabajador(cdc);
        Cargo cargo=cargodao.findById(entidadDto.getCargoTrabajador().getId()).orElse(null);
        trabajador.setCargoTrabajador(cargo);
        trabajador.setTipoTrabajador(entidadDto.getTipoTrabajador());
        trabajador.setEliminarTrabajador(false);
        trabajador.setUrlimagenTrabajador(entidadDto.getUrlimagenTrabajador());
        return trabajador;
    }

    public TrabajadorDto mapearDTO(@NotNull Trabajador trabajador) {
        return new TrabajadorDto(trabajador.getId(),
                trabajador.getNombreTrabajador(),
                trabajador.getApellidopaTrabajador(),
                trabajador.getApellidomaTrabajador(),
                trabajador.getGeneroTrabajador(),
                trabajador.getFechanaTrabajador(),
                trabajador.getEstadoCivilTrabajador(),
                trabajador.getTelcelularTrabajador(),
                trabajador.getClaveElectorTrabajador(),
                trabajador.getCodigoPostalTrabajador(),
                trabajador.getCalleTrabajador(),
                new MunicipioDto(trabajador.getMunicipioTrabajador().getId(),
                        trabajador.getMunicipioTrabajador().getNombreMunicipio(),
                        trabajador.getMunicipioTrabajador().getCabeceraMunicipal()),
                trabajador.getColoniaTrabajador(),
                trabajador.getTelcasaTrabajador(),
                trabajador.getSeccionTrabajador(),
                trabajador.getLocalidadTrabajador(),
                trabajador.getTipoSanguineoTrabajador(),
                trabajador.getCorreoElectronicoTrabajador(),
                trabajador.getInstagramTrabajador(),
                trabajador.getFacebookTrabajador(),
                trabajador.getTwitterTrabajador(),
                trabajador.getFolioTrabajador(),
                new RegionDto(trabajador.getRegionTrabajador().getId(),trabajador.getRegionTrabajador().getNombreRegion()),
                new SectorDto(trabajador.getSectorTrabajador().getId(),trabajador.getSectorTrabajador().getNombreSector()),
                new CdcDto(trabajador.getCdcTrabajador().getId(),trabajador.getCdcTrabajador().getNombreCdc()),
                new CargoDto(trabajador.getCargoTrabajador().getId(),trabajador.getCargoTrabajador().getNombreCargo()),
                new CluaDto(trabajador.getCluaTrabajador().getId(),trabajador.getCluaTrabajador().getEstadoClua(),trabajador.getCluaTrabajador().getFechaCreacionClua(),trabajador.getCluaTrabajador().getVigenciaClua()),
                trabajador.getTipoTrabajador(),
                trabajador.getEliminarTrabajador(),
                trabajador.getUrlimagenTrabajador(),
                trabajador.getCursos().stream().map(curso-> new CursoDto(
                        curso.getId(),
                        curso.getNombreCurso(),
                        curso.getCdcCurso(),
                        curso.getEstatusCurso(),
                        curso.getPeriodoCurso(),
                        curso.getCodigoCruso(),
                        curso.getAnioCurso(),
                        curso.getHoraInicioCurso(),
                        curso.getHoraFinCurso(),
                        curso.getTamanioCurso())).collect(Collectors.toSet()),
                new UsuarioDto(trabajador.getUsuario().getId(),
                        trabajador.getUsuario().getEstadoUsuario(),
                        trabajador.getUsuario().getUserNameUsuario(),
                        trabajador.getUsuario().getPasswordUsuario(),
                        trabajador.getUsuario().getTokenPasswordUsuario(),
                        null,null));
    }
}
