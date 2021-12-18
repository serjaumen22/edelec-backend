package com.example.edelec.services;


import com.example.edelec.entitys.Usuario;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService  {

    Usuario createUsuario(Usuario usuario);
    Usuario getUsuarioById(Integer IdUsuario);
    List<Usuario> getUsuarioByName(String nombre);
    Integer Login(Usuario usuario);
    Usuario getUsuarioByUser(String User);

    Usuario updateUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();
    void deleteUsuario(Integer IdCarrera);


}
