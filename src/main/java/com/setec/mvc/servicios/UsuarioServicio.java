package com.setec.mvc.servicios;

import com.setec.mvc.dao.Usuariodao;
import com.setec.mvc.entidades.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UsuarioServicio implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);
    @Autowired
    private Usuariodao usuariodao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= usuariodao.findByUserNameUsuario(username);
        if(usuario==null){
            logger.error("error de login");
            throw new  UsernameNotFoundException("error de login");
        }
        List<GrantedAuthority> authorities=usuario.getRoles().stream()
                .map(role-> new SimpleGrantedAuthority(role.getDescripcionRol()))
                .collect(Collectors.toList());
        return new User(usuario.getUserNameUsuario(), usuario.getPasswordUsuario(), usuario.getEstadoUsuario(), true, true, true, authorities);
    }
}
