package com.setec.mvc.controlador;

import com.setec.mvc.dtos.MunicipioDto;
import com.setec.mvc.servicios.MunicipioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/municipio")
public class MunicipioControlador {

    @Autowired
    private MunicipioServicioImpl municipioServicio;

    @GetMapping()
    public List<MunicipioDto> listarMunicipios(){
        return municipioServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDto> obtenerMunicipio(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(municipioServicio.findById(id));
    }
    @GetMapping("/term/{term}")
    public List<MunicipioDto> findByTerm(@PathVariable(name="term")String term){
        return municipioServicio.findByTerm(term);
    }
}
