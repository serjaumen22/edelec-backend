package com.example.edelec.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "carreras")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrera;

    @NotNull
    @Size(min = 5,max = 30)
    @Column(name = "nombres", nullable = false, unique = true)
    private String nombreCarrera;

    @Column(name = "perfiles", nullable = false)
    private String perfil;

    @NotNull
    @Size(min = 10, max = 300)
    @Column(name = "descripciones", nullable = false)
    private String descripcionDeCarrera;

    @NotNull
    @Column(name = "tasas_de_empleabilidad", nullable = false)
    private Float tasaDeEmpleabilidad;

    @NotNull
    @Column(name = "salariosPromedios", nullable = false)
    private Integer salarioPromedio;

    @JsonIgnore
    @OneToMany(mappedBy = "carrera",cascade ={CascadeType.ALL})
    private List<Respuesta> respuestas;

}
