package com.setec.mvc.security;

import com.setec.mvc.dao.Usuariodao;
import com.setec.mvc.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private Usuariodao usuariodao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= usuariodao.findByUserNameUsuario(username)
                .orElseThrow(()->new UsernameNotFoundException("el usuario "+username+" no existe"));
        System.out.println(usuario);
        return new UserDetailsImpl(usuario);
    }
}
