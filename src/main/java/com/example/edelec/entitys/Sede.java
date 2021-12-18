package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "sedes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")

    @Column(name = "ubicaciones", nullable = false)
    private Long  ubicacion;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "direcciones", nullable = false)
    private String direccion;


    @ManyToOne
    @JoinColumn(name = "idUniversidad",nullable = false,  foreignKey = @ForeignKey(name = "FK_Sede_Universidad"))
    private Universidad universidad;


}
