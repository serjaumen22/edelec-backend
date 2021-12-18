package com.example.edelec;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EdelecApplicationTests {
    @Autowired
     private UsuarioRepository repo;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        Usuario us = new Usuario();
        us.setApellido("Mendoza");
        us.setCorreo("weaqfsafsae49@gmial.com");
        us.setNombre("Flavia");
        us.setUserName("flajau");
        us.setContrasena(encoder.encode("hola13040"));
        Usuario retorno = repo.save(us);
        assert (retorno.getUserName().equalsIgnoreCase(us.getUserName()));

    }

}
