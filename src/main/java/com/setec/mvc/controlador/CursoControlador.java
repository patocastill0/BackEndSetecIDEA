package com.setec.mvc.controlador;

import com.setec.mvc.dtos.CursoDto;
import com.setec.mvc.servicios.CursoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/curso")
public class CursoControlador {

    @Autowired
    private CursoServicioImpl cursoServicio;

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping()
    public List<CursoDto> listarCurso(){
        return cursoServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> obtenerCurso(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(cursoServicio.findById(id));
    }

    //@Secured({"ROLE_ADMINSYSTEMAS"})
    @PostMapping
    public ResponseEntity<CursoDto> guardarCurso(@RequestBody CursoDto  cursoDto) {
        return new ResponseEntity<>(cursoServicio.save(cursoDto), HttpStatus.CREATED);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> actualizarCurso(@RequestBody CursoDto cursoDto, @PathVariable(name = "id") String id) {
        CursoDto cursoDto1 = cursoServicio.update(cursoDto, id);
        return new ResponseEntity<>(cursoDto1, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCurso(@PathVariable String id){
        cursoServicio.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
