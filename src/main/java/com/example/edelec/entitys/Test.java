package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTest;

    @NotNull
    @Size(min = 20)
    @Column(name = "descripciónes")
    private String description;

    @JsonIgnore
    @Column(name = "activado")
    private Boolean activate;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fechas", updatable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario",  foreignKey = @ForeignKey(name = "FK_Test_Usuario"))
    private Usuario usuario;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Pregunta> preguntas;
}


