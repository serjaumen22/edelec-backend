package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "preguntas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(name = "contenidos", nullable = false)
    private String contenido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idTest",  foreignKey = @ForeignKey(name = "FK_Pregunta_Test"))
    private Test test;


    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<Respuesta> respuesta;
}
