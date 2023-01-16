package com.setec.mvc.controlador;

import com.setec.mvc.dtos.RegionDto;
import com.setec.mvc.dtos.RoleDto;
import com.setec.mvc.servicios.RegionServicioImpl;
import com.setec.mvc.servicios.RoleServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleControlador {

    @Autowired
    private RoleServicioImpl roleServicio;

    @GetMapping()
    public List<RoleDto> listarRoles(){
        return roleServicio.findAll();
    }

    //@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_ADMINSYSTEMAS","ROLE_TESORERO","ROLE_CONTADOR"})
    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> obtenerRole(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(roleServicio.findById(id));
    }
}
