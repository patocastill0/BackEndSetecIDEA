package com.setec.mvc.servicios;

import com.setec.mvc.dao.*;
import com.setec.mvc.dtos.*;
import com.setec.mvc.dtos.reportesJasper.TrabajadorJasperDTO;
import com.setec.mvc.entidades.*;
import com.setec.mvc.enums.TrabajadorType;

import com.setec.mvc.general.EntidadRespuesta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    private String letra;

    @Override
    public TrabajadorDto findById(String id) {
        TrabajadorDto trabajadorDto=null;
        if(trabajadordao.findById(id)!=null) {
            Trabajador trabajador=trabajadordao.findById(id).get();
            trabajadorDto= mapearDTO(trabajador);
        }
        return trabajadorDto;
    }

    public TrabajadorDto findByFolio(int folio) {
        Trabajador trabajador=trabajadordao.findByFolio(folio);

        if(trabajador!=null){
            TrabajadorDto trabajadordto = new TrabajadorDto(
                    trabajador.getId(),
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
                    trabajador.getNumeroCalle(),
                    new MunicipioDto(trabajador.getMunicipioTrabajador().getId(),trabajador.getMunicipioTrabajador().getNombreMunicipio(),trabajador.getMunicipioTrabajador().getCabeceraMunicipal()),
                    trabajador.getColoniaTrabajador(),
                    trabajador.getTelcasaTrabajador(),
                    trabajador.getSeccionTrabajador(),
                    trabajador.getLocalidadTrabajador(),
                    trabajador.getTipoSanguineoTrabajador(),
                    trabajador.getCorreoElectronicoTrabajador(),
                    trabajador.getInstagramTrabajador(),
                    trabajador.getFacebookTrabajador(),
                    trabajador.getTwitterTrabajador(),
                    folio(Integer.parseInt(trabajador.getFolioTrabajador())),
                    new RegionDto(trabajador.getRegionTrabajador().getId(),trabajador.getRegionTrabajador().getNombreRegion()),
                    new SectorDto(trabajador.getSectorTrabajador().getId(), trabajador.getSectorTrabajador().getNombreSector()),
                    new CdcDto(trabajador.getCdcTrabajador().getId(), trabajador.getCdcTrabajador().getNombreCdc()),
                    new CargoDto(trabajador.getCargoTrabajador().getId(),trabajador.getCargoTrabajador().getNombreCargo()),
                    (trabajador.getCluaTrabajador()!=null)?
                            new CluaDto(trabajador.getCluaTrabajador().getId(),trabajador.getCluaTrabajador().getEstadoClua(),trabajador.getCluaTrabajador().getFechaCreacionClua(),trabajador.getCluaTrabajador().getVigenciaClua(),trabajador.getCluaTrabajador().getAnioAfiliacion()) :new CluaDto("","",null,"",""),
                    trabajador.getTipoTrabajador(),
                    trabajador.getEliminarTrabajador(),
                    trabajador.getUrlimagenTrabajador(),
                    null ,
                    null,

                    trabajador.isHasactanacimiento(),
                    trabajador.isHascomprobante(),
                    trabajador.isHascurp(),
                    trabajador.isHasine(),

                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getAnioAfiliacion():" ",
                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getId():" ");
            return trabajadordto;
        }else
            return new TrabajadorDto();
    }

    public TrabajadorJasperDTO findByFolioTrabajador(String folio) {
        Trabajador trabajador=trabajadordao.findByFolioTrabajador(String.valueOf(folio) );

        if(trabajador!=null){
            TrabajadorJasperDTO trabajadordto = new TrabajadorJasperDTO(
                    trabajador.getId(),
                    trabajador.getNombreTrabajador(),
                    trabajador.getApellidopaTrabajador(),
                    trabajador.getApellidomaTrabajador(),
                    trabajador.getGeneroTrabajador().name().substring(0,1),
                    trabajador.getFechanaTrabajador(),
                    trabajador.getEstadoCivilTrabajador(),
                    trabajador.getTelcelularTrabajador(),
                    trabajador.getClaveElectorTrabajador(),
                    trabajador.getCodigoPostalTrabajador(),
                    trabajador.getCalleTrabajador(),
                    trabajador.getNumeroCalle(),
                    trabajador.getMunicipioTrabajador().getNombreMunicipio(),
                    trabajador.getColoniaTrabajador(),
                    trabajador.getTelcasaTrabajador(),
                    trabajador.getSeccionTrabajador(),
                    trabajador.getLocalidadTrabajador(),
                    trabajador.getTipoSanguineoTrabajador(),
                    trabajador.getCorreoElectronicoTrabajador(),
                    trabajador.getInstagramTrabajador(),
                    trabajador.getFacebookTrabajador(),
                    trabajador.getTwitterTrabajador(),
                    folio(Integer.parseInt(trabajador.getFolioTrabajador())),
                    new RegionDto(trabajador.getRegionTrabajador().getId(),trabajador.getRegionTrabajador().getNombreRegion()),
                    new SectorDto(trabajador.getSectorTrabajador().getId(), trabajador.getSectorTrabajador().getNombreSector()),
                    new CdcDto(trabajador.getCdcTrabajador().getId(), trabajador.getCdcTrabajador().getNombreCdc()),
                    new CargoDto(trabajador.getCargoTrabajador().getId(),trabajador.getCargoTrabajador().getNombreCargo()),
                    (trabajador.getCluaTrabajador()!=null)?
                    trabajador.getCluaTrabajador().getId(): " ",
                    trabajador.getTipoTrabajador(),
                    trabajador.getEliminarTrabajador(),
                    trabajador.getUrlimagenTrabajador(),
                    null ,
                    null,

                    obtenerchar(trabajador.isHasactanacimiento()),
                    obtenerchar(trabajador.isHascomprobante()),
                    obtenerchar(trabajador.isHascurp()),
                    obtenerchar(trabajador.isHasine()),

                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getAnioAfiliacion():" ",
                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getId():" ");
            return trabajadordto;
        }else
            return new TrabajadorJasperDTO();
    }


    public List<TrabajadorDto> findByTerm(String term) {
        String clua=" ";
        List<Trabajador> listaTrabajadores = trabajadordao.findByTerm(term,term,term,term,term);
        List<TrabajadorDto> listaTrabajadorDTO= new ArrayList<>();

        for (Trabajador trabajador : listaTrabajadores) {
            if(trabajador.getCluaTrabajador()!=null){
                clua=trabajador.getCluaTrabajador().getId();
            }
            listaTrabajadorDTO.add(new TrabajadorDto(
                    trabajador.getId(),
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
                    trabajador.getNumeroCalle(),
                    new MunicipioDto(trabajador.getMunicipioTrabajador().getId(),trabajador.getMunicipioTrabajador().getNombreMunicipio(),trabajador.getMunicipioTrabajador().getCabeceraMunicipal()),
                    trabajador.getColoniaTrabajador(),
                    trabajador.getTelcasaTrabajador(),
                    trabajador.getSeccionTrabajador(),
                    trabajador.getLocalidadTrabajador(),
                    trabajador.getTipoSanguineoTrabajador(),
                    trabajador.getCorreoElectronicoTrabajador(),
                    trabajador.getInstagramTrabajador(),
                    trabajador.getFacebookTrabajador(),
                    trabajador.getTwitterTrabajador(),
                    folio(Integer.parseInt(trabajador.getFolioTrabajador())),
                    new RegionDto(trabajador.getRegionTrabajador().getId(),trabajador.getRegionTrabajador().getNombreRegion()),
                    new SectorDto(trabajador.getSectorTrabajador().getId(), trabajador.getSectorTrabajador().getNombreSector()),
                    new CdcDto(trabajador.getCdcTrabajador().getId(), trabajador.getCdcTrabajador().getNombreCdc()),
                    new CargoDto(trabajador.getCargoTrabajador().getId(),trabajador.getCargoTrabajador().getNombreCargo()),
                    (trabajador.getCluaTrabajador()!=null)?
                            new CluaDto(trabajador.getCluaTrabajador().getId(),trabajador.getCluaTrabajador().getEstadoClua(),trabajador.getCluaTrabajador().getFechaCreacionClua(),trabajador.getCluaTrabajador().getVigenciaClua(),trabajador.getCluaTrabajador().getAnioAfiliacion()) :new CluaDto("","",null,"",""),
                    trabajador.getTipoTrabajador(),
                    trabajador.getEliminarTrabajador(),
                    trabajador.getUrlimagenTrabajador(),
                    null ,
                    null,

                    trabajador.isHasactanacimiento(),
                    trabajador.isHascomprobante(),
                    trabajador.isHascurp(),
                    trabajador.isHasine(),

                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getAnioAfiliacion():" ",
                    (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getId():" "));
        }

        return listaTrabajadorDTO;

    }


    public String folio(int folio){
        String numero=String.valueOf(folio);
        String cadenaFolio="";
        int tamanioTotal=numero.length()-5;
        for(int i=0; i<tamanioTotal; i++)
            cadenaFolio+="0";
        return cadenaFolio+numero;
    }

    @Override
    public TrabajadorDto save(TrabajadorDto entity) {
        Trabajador trabajador=trabajadordao.save(mapearEntity(entity));
        return mapearDTO(trabajador);
    }
    public Object crear(TrabajadorDto trabajadorDTO) {
        System.out.println(trabajadorDTO.getId()+"esta es la curp");
        if((trabajadordao.existsById(trabajadorDTO.getId())))
            return 0; // significa que el empleado ya existe por la curp
        if((!trabajadordao.existsById(trabajadorDTO.getId()))){
            Trabajador trabajador= mapearEntity(trabajadorDTO);
            Trabajador nuevoTrabajador=trabajadordao.save(trabajador);
            TrabajadorDto tipotrabajador= mapearDTO(nuevoTrabajador);

            return tipotrabajador;
        }
        return null;
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
        if(trabajadordao.findById(id)!=null)
            trabajadordao.delete(trabajadordao.findById(id).get());
    }

    @Override
    public TrabajadorDto update(TrabajadorDto trabajadordto, String id) {
        Trabajador trabajador = trabajadordao.findById(id).orElse(null);

        //persona.setCurp(trabajadordto.getCurp());
        trabajador.setNombreTrabajador(trabajadordto.getNombreTrabajador());
        trabajador.setApellidopaTrabajador(trabajadordto.getApellidopaTrabajador());
        trabajador.setApellidomaTrabajador(trabajadordto.getApellidomaTrabajador());
        trabajador.setGeneroTrabajador(trabajadordto.getGeneroTrabajador());
        trabajador.setFechanaTrabajador(trabajadordto.getFechanaTrabajador());
        trabajador.setEstadoCivilTrabajador(trabajadordto.getEstadoCivilTrabajador());
        trabajador.setTelcelularTrabajador(trabajadordto.getTelcelularTrabajador());
        trabajador.setClaveElectorTrabajador(trabajadordto.getClaveElectorTrabajador());
        trabajador.setCodigoPostalTrabajador(trabajadordto.getCodigoPostalTrabajador());
        trabajador.setCalleTrabajador(trabajadordto.getCalleTrabajador());
        trabajador.setNumeroCalle(trabajadordto.getNumeroCalle());
        Municipio municipio = municipiodao.findById(trabajadordto.getMunicipioTrabajador().getId()).orElse(null);
        trabajador.setMunicipioTrabajador(municipio);
        trabajador.setColoniaTrabajador(trabajadordto.getColoniaTrabajador());
        trabajador.setTelcasaTrabajador(trabajadordto.getTelcasaTrabajador());
        trabajador.setSeccionTrabajador(trabajadordto.getSeccionTrabajador());
        trabajador.setLocalidadTrabajador(trabajadordto.getLocalidadTrabajador());
        trabajador.setTipoSanguineoTrabajador(trabajadordto.getTipoSanguineoTrabajador());
        trabajador.setCorreoElectronicoTrabajador(trabajadordto.getCorreoElectronicoTrabajador());
        trabajador.setInstagramTrabajador(trabajadordto.getInstagramTrabajador());
        trabajador.setFacebookTrabajador(trabajadordto.getFacebookTrabajador());
        trabajador.setTwitterTrabajador(trabajadordto.getTwitterTrabajador());
        //folio
        Region region = regiondao.findById(trabajadordto.getRegionTrabajador().getId()).orElse(null);
        trabajador.setRegionTrabajador(region);

        Sector sector = sectordao.findById(trabajadordto.getSectorTrabajador().getId()).orElse(null);
        trabajador.setSectorTrabajador(sector);

        Cdc cdc = cdcdao.findById(trabajadordto.getCdcTrabajador().getId()).orElse(null);
        trabajador.setCdcTrabajador(cdc);

        Cargo cargo = cargodao.findById(trabajadordto.getCargoTrabajador().getId()).orElse(null);
        trabajador.setCargoTrabajador(cargo);

        Clua clua = cluadao.findById(" ").orElse(null);
        if(clua!= null){
            trabajador.setCluaTrabajador(clua);}

        //trabajador.setFolio(Integer.parseInt(trabajadordto.getFolio()));
        trabajador.setHasactanacimiento(trabajadordto.isHasactanacimiento());
        trabajador.setHascomprobante(trabajadordto.isHascomprobante());
        trabajador.setHascurp(trabajadordto.isHascurp());
        trabajador.setHasine(trabajadordto.isHasine());

        Trabajador trabajadoractualizado = trabajadordao.save(trabajador);

        return  mapearDTO(trabajadoractualizado);
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
        trabajador.setNumeroCalle(entidadDto.getNumeroCalle());

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

        Clua clua = cluadao.findById(" ").orElse(null);
        if(clua!= null){
            trabajador.setCluaTrabajador(clua);}

        trabajador.setTipoTrabajador(entidadDto.getTipoTrabajador());
        trabajador.setEliminarTrabajador(false);
        trabajador.setUrlimagenTrabajador(entidadDto.getUrlimagenTrabajador());

        trabajador.setHasactanacimiento(entidadDto.isHasactanacimiento());
        trabajador.setHascomprobante(entidadDto.isHascomprobante());
        trabajador.setHascurp(entidadDto.isHascurp());
        trabajador.setHasine(entidadDto.isHasine());
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
                trabajador.getNumeroCalle(),
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
                cluavacia(trabajador),
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
                usuariovacio(trabajador),
                trabajador.isHasactanacimiento(),
                trabajador.isHascomprobante(),
                trabajador.isHascurp(),
                trabajador.isHasine(),
                (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getAnioAfiliacion(): "",
                (trabajador.getCluaTrabajador()!=null)?trabajador.getCluaTrabajador().getId(): "");
    }

    public String obtenerchar (boolean signo){
        if(signo)
            return letra = "SI";
        else
            return letra = "NO";
    }
    public CluaDto cluavacia (Trabajador trabajador){

        if(trabajador.getCluaTrabajador()!= null)
           return new CluaDto(trabajador.getCluaTrabajador().getId(),trabajador.getCluaTrabajador().getEstadoClua(),trabajador.getCluaTrabajador().getFechaCreacionClua(),trabajador.getCluaTrabajador().getVigenciaClua(), trabajador.getCluaTrabajador().getAnioAfiliacion());
        else
            return null;
    }
    public UsuarioDto usuariovacio(Trabajador trabajador){
        if(trabajador.getUsuario()!=null)
            return new UsuarioDto(trabajador.getUsuario().getId(),
                    trabajador.getUsuario().getEstadoUsuario(),
                    trabajador.getUsuario().getUserNameUsuario(),
                    trabajador.getUsuario().getPasswordUsuario(),
                    trabajador.getUsuario().getTokenPasswordUsuario(),
                    null,null);
            else
                return null;
    }

    public TrabajadorDto updateImagen(String ruta, String id) {
        Trabajador trabajador=trabajadordao
                .findById(id).orElse(null);

        trabajador.setUrlimagenTrabajador(ruta);
        Trabajador trabajadorActualizado=trabajadordao.save(trabajador);
        return mapearDTO(trabajadorActualizado);
    }
}
