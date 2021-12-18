package com.example.edelec.security.config.Service;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserDetailsService {
    private final UsuarioRepository repo;

    public UserService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario us = repo.getByUser(username);
       List<GrantedAuthority> roles= new ArrayList<>();
       roles.add(new SimpleGrantedAuthority("ADMIN"));
       UserDetails det= new User(us.getUserName(),us.getContrasena(),roles);


        return det;
    }
}
