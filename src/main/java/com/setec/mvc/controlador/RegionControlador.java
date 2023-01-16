package com.setec.mvc.controlador;

import com.setec.mvc.dtos.RegionDto;
import com.setec.mvc.servicios.RegionServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionControlador {

    @Autowired
    private RegionServicioImpl regionServicio;

    @GetMapping()
    public List<RegionDto> listarRegiones(){
        return regionServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<RegionDto> obtenerRegion(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(regionServicio.findById(id));
    }
}
