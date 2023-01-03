package com.setec.mvc.controlador;

import com.setec.mvc.dtos.CargoDto;
import com.setec.mvc.servicios.CargoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cargo")
public class CargoControlador {

    @Autowired
    private CargoImpl cargoImpl;

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping()
    public List<CargoDto> listarCargos(){
        return cargoImpl.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<CargoDto> obtenerCargo(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(cargoImpl.findById(id));
    }

    //@Secured({"ROLE_ADMINSYSTEMAS"})
    @PostMapping
    public ResponseEntity<CargoDto> guardarCargo(@RequestBody CargoDto  cargoDto) {
        return new ResponseEntity<>(cargoImpl.save(cargoDto), HttpStatus.CREATED);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @PutMapping("/{id}")
    public ResponseEntity<CargoDto> actualizarCargo(@RequestBody CargoDto cargoDto, @PathVariable(name = "id") Integer id) {
        CargoDto cargoDto1 = cargoImpl.update(cargoDto, id);
        return new ResponseEntity<>(cargoDto1, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_ADMINSYSTEMAS"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCargo(@PathVariable int id){
        cargoImpl.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
