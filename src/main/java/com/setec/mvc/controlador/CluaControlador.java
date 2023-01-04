package com.setec.mvc.controlador;

import com.setec.mvc.dtos.CdcDto;
import com.setec.mvc.dtos.CluaDto;
import com.setec.mvc.servicios.CdcServicioImpl;
import com.setec.mvc.servicios.CluaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clua")
public class CluaControlador {

    @Autowired
    private CluaServicioImpl cluaServicio;

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping()
    public List<CluaDto> listarClua(){
        return cluaServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<CluaDto> obtenerClua(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(cluaServicio.findById(id));
    }

    //@Secured({"ROLE_ADMINSYSTEMAS"})
    @PostMapping
    public ResponseEntity<CluaDto> guardarClua(@RequestBody CluaDto  cluaDto) {
        return new ResponseEntity<>(cluaServicio.save(cluaDto), HttpStatus.CREATED);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @PutMapping("/{id}")
    public ResponseEntity<CluaDto> actualizarClua(@RequestBody CluaDto cluaDto, @PathVariable(name = "id") String id) {
        CluaDto cluaDto1 = cluaServicio.update(cluaDto, id);
        return new ResponseEntity<>(cluaDto1, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarClua(@PathVariable String id){
        cluaServicio.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
