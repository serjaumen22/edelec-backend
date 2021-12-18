package com.example.edelec.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "universidades")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniversidad;

    @NotNull
    @Size(min = 10 , max = 50 , message = "El nombre es muy pqueño")
    @Column(name = "Univerdidad", nullable = false, length = 20, unique = true)
    private String name;

    @NotNull
    @Size(min = 20)
    @Column(name = "descripción", nullable = true, length = 20, unique = true)
    private String description;

    @Column(name = "imagen", nullable = true)
    private String image;

    @NotNull
    @Column(name = "tipo_gestion")
    private String tipoGestion;

    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Sede> sede;
    @JsonIgnore
    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Comments> coments;


}
