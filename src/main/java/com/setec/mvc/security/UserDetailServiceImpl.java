package com.setec.mvc.security;

import com.setec.mvc.dao.Usuariodao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private Usuariodao usuariodao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuariodao.findByUserNameUsuario(username)
                .orElseThrow(()->new UsernameNotFoundException("el usuario "+username+" no existe"));
        return
    }
}
