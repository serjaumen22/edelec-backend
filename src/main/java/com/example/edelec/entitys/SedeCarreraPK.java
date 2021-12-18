package com.example.edelec.entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class SedeCarreraPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="idSede", nullable = false)
    private Sede idSede;

    @ManyToOne
    @JoinColumn(name="idCarrera", nullable = false)
    private Carrera idCarrera;
}
