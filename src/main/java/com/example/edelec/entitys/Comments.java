package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "Fechas", nullable = false)
    @JsonIgnore
    private LocalDateTime tiempo;

    @NotNull
    @NotBlank
    @Size(min = 1, message = "Este mensaje esta vacio")
    @Column(name = "contenidos", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idUsuarios",nullable = false,  foreignKey = @ForeignKey(name = "FK_Usuario_Comentario"))
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "idUniversidades",nullable = false,  foreignKey = @ForeignKey(name ="FK_Universidada_Comentario"))
    private Universidad universidad;

    @NotNull
    private int votes;
}
