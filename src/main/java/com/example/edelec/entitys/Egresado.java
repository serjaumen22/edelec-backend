package com.example.edelec.entitys;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "egresado")
@Setter
@Getter

public class Egresado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEgresado;

    @NotNull
    @Column(name = "nombre_egresado")
    private String nombreEgresado;

    //@ManyToOne
    //@JoinColumn(name="id_sede_carrera", nullable = false, foreignKey = @ForeignKey(name="fk_sede_carrera"))
    //private SedeCarrera sedeCarrera;
    @ManyToOne
    @JoinColumn(name="id_sede", nullable = false, foreignKey = @ForeignKey(name="FK_sede"))
    private Sede sede;

    @ManyToOne
    @JoinColumn(name="id_carrera", nullable = false, foreignKey = @ForeignKey(name="FK_carrera"))
    private Carrera carrera;

    @NotNull
    @Column(name = "curriculum")
    private String curriculum;  

    @Column(name = "foto_egresado")
    private String fotoEgresado;

}
