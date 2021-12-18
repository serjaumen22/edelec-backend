package com.example.edelec.services.impl;

import com.example.edelec.entitys.Usuario;

import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.UsuarioRepository;
import com.example.edelec.services.UsuarioService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }


    @Override
    public Usuario createUsuario(Usuario usuario) {
         Usuario user =usuario;
         user.setContrasena(encoder.encode(usuario.getContrasena()));

        return usuarioRepository.save(user);
    }


    @Override
    public Usuario getUsuarioById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(()->new ResourceNotFoundException("No Existe el usuario: "+idUsuario));
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer IdUsuario){
        usuarioRepository.deleteById(IdUsuario);
    }

    public  Usuario getUsuarioByUser(String user){
        return usuarioRepository.getByUser(user);
    }

    public List<Usuario> getUsuarioByName(String nombre){
         return usuarioRepository.getAllByName(nombre);
    }

    public Integer Login(Usuario usuario) {
        return 0;
    }
}
