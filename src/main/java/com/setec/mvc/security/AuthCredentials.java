package com.setec.mvc.security;

import com.setec.mvc.entidades.Role;
import lombok.Data;

import java.util.List;

@Data
public class AuthCredentials {

    private String email;
    private String password;
    private List<Role>roles;
}
