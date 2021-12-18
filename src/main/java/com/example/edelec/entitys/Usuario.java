package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "usuarios", nullable = false , unique = true)
    private String userName;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "nombres", nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "apellidos", nullable = false)
    private String apellido;

    @NotNull
    @Email
    @Column(name = "correos", nullable = false)
    private String correo;

    @NotNull
    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade ={CascadeType.ALL})
    private List<Comments> coment;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Test> tests;


}
