package com.setec.mvc.servicios;

import com.setec.mvc.dao.Usuariodao;
import com.setec.mvc.dtos.RoleDto;
import com.setec.mvc.dtos.TrabajadorDto;
import com.setec.mvc.dtos.UsuarioDto;
import com.setec.mvc.entidades.Usuario;
import com.setec.mvc.general.EntidadRespuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UsuarioServicioImpl implements UserDetailsService, Crud<UsuarioDto> {

    private Logger loger = LoggerFactory.getLogger(UsuarioServicioImpl.class);

    @Autowired
    private Usuariodao usuariodao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario = usuariodao.findByUserNameUsuario(username);
        if(usuario==null){
            loger.error("Error de login: usuario "+ username + " no existe");
            throw new UsernameNotFoundException("Error de login: usuario "+ username + " no existe");
        }
        //Stream recibe flujos de datos
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role-> new SimpleGrantedAuthority(role.getDescripcionRol()))
                .collect(Collectors.toList());
        return new User(usuario.getUserNameUsuario(), usuario.getPasswordUsuario(), usuario.getEstadoUsuario(), true, true, true, authorities);
    }

    @Override
    public UsuarioDto findById(String id) {
        Usuario usuario=usuariodao.findById(Integer.valueOf(id)).orElse(null);

        UsuarioDto usuarioDTO = new UsuarioDto(usuario.getId(),usuario.getEstadoUsuario(),"","",usuario.getTokenPasswordUsuario()
                ,usuario.getRoles()
                .stream()
                .map(role-> new RoleDto(role.getId(),role.getDescripcionRol()))
                .collect(Collectors.toSet()),new TrabajadorDto());
        return usuarioDTO;
    }

    @Override
    public UsuarioDto save(UsuarioDto tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDto> findAll() {
        return null;
    }

    @Override
    public EntidadRespuesta<UsuarioDto> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UsuarioDto update(UsuarioDto tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object mapearEntity(UsuarioDto entidadDto) {
        return null;
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
