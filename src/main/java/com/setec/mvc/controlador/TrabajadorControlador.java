package com.setec.mvc.controlador;


import com.setec.mvc.dao.Trabajadordao;
import com.setec.mvc.dtos.*;
import com.setec.mvc.dtos.reportesJasper.TrabajadorJasperDTO;
import com.setec.mvc.entidades.Trabajador;
import com.setec.mvc.general.EntidadRespuesta;
import com.setec.mvc.servicios.*;
import com.setec.mvc.servicios.Jasper.ServiceJasper;
import com.setec.mvc.servicios.TrabajadorServicioImpl;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorControlador {

    @Autowired
    private TrabajadorServicioImpl trabajadorser;
    @Autowired
    private SectorServicioImpl sectorser;
    @Autowired
    private CargoImpl cargoser;
    @Autowired
    private RegionServicioImpl regionser;
    @Autowired
    private CdcServicioImpl cdcsser;

    @Autowired
    private Trabajadordao trabajadordao; //Para uso del JasperSoft

    @Autowired
    private ServiceJasper servicejasper;


    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDto> findByID(@PathVariable(name="id")String id){
        return ResponseEntity.ok(trabajadorser.findById(id));
    }

    @GetMapping("/folio/{folio}")
    public ResponseEntity <TrabajadorJasperDTO> findByFolio(@PathVariable(name="folio")String folio){
        return ResponseEntity.ok(trabajadorser.findByFolioTrabajador(folio));
    }


    @GetMapping("/sector/{id}")
    public ResponseEntity<SectorDto> findByIDSector(@PathVariable(name="id")String id){
        return ResponseEntity.ok(sectorser.findById(id));
    }

    @GetMapping("/term/{term}")
    public List<TrabajadorDto> findByTerm(@PathVariable(name="term")String term){
        return trabajadorser.findByTerm(term);
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<CargoDto> findByIDCargo(@PathVariable(name="id")String id){
        return ResponseEntity.ok(cargoser.findById(id));
    }
    @GetMapping("/region/{id}")
    public ResponseEntity<RegionDto> findByIDRegion(@PathVariable(name="id")String id){
        return ResponseEntity.ok(regionser.findById(id));
    }
    @GetMapping("/cdcs/{id}")
    public ResponseEntity<CdcDto> findByIDCdcs (@PathVariable(name="id")Integer id){
        return ResponseEntity.ok(cdcsser.findById(id));
    }

    //--------------------------------------------
    /**@PostMapping()
    public ResponseEntity <TrabajadorDTO> añadirTrabajador(@RequestBody TrabajadorDTO trabajadordto){
    TrabajadorDTO trabajadorDTO = trabajadorser.save(trabajadordto);
    if(trabajadorDTO == null)
    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    else
    return new ResponseEntity<>(trabajadorDTO,HttpStatus.OK);
    }*/
    //-------------------------------------------------


    @PostMapping()
    public ResponseEntity<TrabajadorDto> crearEmpleado(@RequestBody TrabajadorDto  trabajadordto) {
        Object obj=trabajadorser.crear(trabajadordto);
        if(!(obj instanceof TrabajadorDto)){
            if((int)obj ==0){
                return new ResponseEntity<>(null, HttpStatus.FOUND);}
        }
        return new ResponseEntity<>((TrabajadorDto)obj, HttpStatus.CREATED);

    }
    @PostMapping("/guardarimagen")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("trabajador") String trabajador ){
        Map<String, Object> respuesta = new HashMap<>();
        TrabajadorDto trabajadorRespuesta=null;
        TrabajadorDto trabajadordto = trabajadorser.findById(trabajador);
        if(!archivo.isEmpty()){
            String nombreArchivo= UUID.randomUUID().toString()+ "_"+ archivo.getOriginalFilename().replace(" ",  "");
            Path rutaArchivo= Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();

            try {
                Files.copy(archivo.getInputStream(), rutaArchivo);
            } catch (IOException ex) {
                respuesta.put("mensaje", "Error al subir la imagen "+nombreArchivo);
                //respuesta.put("mensaje", ex.getMessage().concat(": ").concat(ex.getCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            String nombreFotoAnterior=trabajadordto.getUrlimagenTrabajador();
            if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0){
                Path rutaFotoAnterior= Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
                File archivoFotoAnterior=rutaFotoAnterior.toFile();
                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
                    archivoFotoAnterior.delete();
                }
            }
            //Trabajador trabajador = trabajadordao.findById(idtrabajador).get();
            //trabajador.setUrlimagenTrabajador(nombreArchivo);
            //Object object = trabajadorser.crear(trabajador);
            trabajadorRespuesta = trabajadorser.updateImagen(nombreArchivo, trabajador);
            respuesta.put("usuario", trabajadorRespuesta);
            respuesta.put("mensaje","Has subido correctamene la imagen: "+nombreArchivo );
        }
        return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDto> actulizarEmpleado(@RequestBody TrabajadorDto  trabajadordto, @PathVariable (name="id")String id){
        TrabajadorDto trabajadoractualizado = trabajadorser.update(trabajadordto, id);
        return new ResponseEntity<>(trabajadoractualizado,HttpStatus.OK);
    }

    @GetMapping("/page/{page}")
    public EntidadRespuesta<TrabajadorDto> listar(@PathVariable Integer page, @RequestParam(value = "pageSize",
            defaultValue = "10", required = false)int cantidadPagina){
        return trabajadorser.findAll(page,cantidadPagina);
    }
    @GetMapping("/sector")
    public List<SectorDto> listarsector(){
        return sectorser.findAll();
    }
    @GetMapping("/cargo")
    public List<CargoDto> listarcargo(){
        return cargoser.findAll();
    }
    @GetMapping("/region")
    public List<RegionDto> listarregion(){
        return regionser.findAll();
    }
    @GetMapping("/cdcs")
    public List<CdcDto> listarcdcs(){
        return cdcsser.findAll();
    }
    /**
    @GetMapping("/pdf/{folio}/{seleccionado}/{nombreempresa}/{domicilioempresa}/{seleccionadopago}")
    public void downloadPdf(HttpServletResponse response, @PathVariable(name="folio")int folio, @PathVariable(name="seleccionado")String seleccionado, @PathVariable(name="nombreempresa")String nombreempresa, @PathVariable(name="domicilioempresa")String domicilioempresa, @PathVariable(name="seleccionadopago")String seleccionadopago){
        try{
            Path file = Paths.get(pdfservicio.generateTrabajadorPdf(folio,seleccionado,nombreempresa,domicilioempresa,seleccionadopago).getAbsolutePath());
            if (Files.exists(file)){
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename"+ file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/

    @GetMapping("/reporte/{format}/{folio}")
    public String generateReport(@PathVariable String format, @PathVariable String folio) throws FileNotFoundException, JRException {
        return servicejasper.exportReport(format, folio);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadd(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") String id){
        Map<String, Object> respuesta = new HashMap<>();
        TrabajadorDto trabajadorRespuesta=null;
        TrabajadorDto trabajador = trabajadorser.findById(id);
        if(!archivo.isEmpty()){
            String nombreArchivo= UUID.randomUUID().toString()+ "_"+ archivo.getOriginalFilename().replace(" ",  "");
            Path rutaArchivo= Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();

            try {
                Files.copy(archivo.getInputStream(), rutaArchivo);
            } catch (IOException ex) {
                respuesta.put("mensaje", "Error al subir la imagen "+nombreArchivo);
                respuesta.put("mensaje", ex.getMessage().concat(": ").concat(ex.getCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior=trabajador.getUrlimagenTrabajador();
            if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0){
                Path rutaFotoAnterior= Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
                File archivoFotoAnterior=rutaFotoAnterior.toFile();
                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
                    archivoFotoAnterior.delete();
                }
            }
            //usuario.setUrl_imagen(nombreArchivo);
            trabajadorRespuesta = trabajadorser.updateImagen(nombreArchivo, id);

            respuesta.put("usuario", trabajadorRespuesta);
            respuesta.put("mensaje","Has subido correctamene la imagen: "+nombreArchivo );
        }
        return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.CREATED);
    }
}
