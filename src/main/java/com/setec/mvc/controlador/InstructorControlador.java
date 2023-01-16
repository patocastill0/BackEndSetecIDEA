package com.setec.mvc.controlador;

import com.setec.mvc.dtos.InstructorDto;
import com.setec.mvc.general.EntidadRespuesta;
import com.setec.mvc.servicios.InstructorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/instructor")
public class InstructorControlador {

    @Autowired
    private InstructorServicioImpl instructorServicio;

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping()
    public List<InstructorDto> listarInstructor(){
        return instructorServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> obtenerInstructor(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(instructorServicio.findById(id));
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/page/{page}")
    public EntidadRespuesta<InstructorDto> listarInstructor(@PathVariable Integer page, @RequestParam(value = "pageSize",defaultValue = "6",required = false)int cantidadPagina){
        return instructorServicio.findAll(page,cantidadPagina);
    }

    //@Secured({"ROLE_ADMINSYSTEMAS"})
    @PostMapping
    public ResponseEntity<InstructorDto> guardarInstructor(@RequestBody InstructorDto  instructorDto) {
        return new ResponseEntity<>(instructorServicio.save(instructorDto), HttpStatus.CREATED);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDto> actualizarInstructor(@RequestBody InstructorDto instructorDto, @PathVariable(name = "id") String id) {
        InstructorDto instructorDto1 = instructorServicio.update(instructorDto, id);
        return new ResponseEntity<>(instructorDto1, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarInstructor(@PathVariable String id){
        instructorServicio.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
