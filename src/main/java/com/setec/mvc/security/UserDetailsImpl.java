package com.setec.mvc.security;

import com.setec.mvc.entidades.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles().stream()
                .map(role-> new SimpleGrantedAuthority(role.getDescripcionRol()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.getPasswordUsuario();
    }

    @Override
    public String getUsername() {
        return usuario.getUserNameUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return usuario.getEstadoUsuario();
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.getEstadoUsuario();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return usuario.
    }
}
