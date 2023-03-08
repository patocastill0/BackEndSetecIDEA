package com.setec.mvc.controlador;

import com.setec.mvc.dtos.CdcDto;
import com.setec.mvc.servicios.CdcServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cdc")
public class CdcControlador {

    @Autowired
    private CdcServicioImpl cdcServicio;

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping()
    public List<CdcDto> listarCdcs(){
        return cdcServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<CdcDto> obtenerCdc(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(cdcServicio.findById(id));
    }

    //@Secured({"ROLE_ADMINSYSTEMAS"})
    @PostMapping
    public ResponseEntity<CdcDto> guardarCdc(@RequestBody CdcDto  cdcDto) {
        return new ResponseEntity<>(cdcServicio.save(cdcDto), HttpStatus.CREATED);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @PutMapping("/{id}")
    public ResponseEntity<CdcDto> actualizarCdc(@RequestBody CdcDto cdcDto, @PathVariable(name = "id") Integer id) {
        CdcDto cdcDto1 = cdcServicio.update(cdcDto, id);
        return new ResponseEntity<>(cdcDto1, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCdc(@PathVariable int id){
        cdcServicio.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
