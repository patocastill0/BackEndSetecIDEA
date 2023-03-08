package com.setec.mvc.controlador;

import com.setec.mvc.dtos.SectorDto;
import com.setec.mvc.servicios.SectorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sector")
public class SectorControlador {

    @Autowired
    private SectorServicioImpl sectorServicio;

    @GetMapping()
    public List<SectorDto> listarSectores(){
        return sectorServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> obtenerSector(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(sectorServicio.findById(id));
    }
}
