package com.example.edelec.services;


import com.example.edelec.entitys.Egresado;

import java.util.List;

public interface EgresadoService {
    Egresado createEgresado(Egresado carrera);
    List<Egresado> getAllEgresado();
    //List<Egresado> getEgresadoUniversidadCarrera(String nameUniversidad, String nameCarrera);
    Egresado updateEgresado(Egresado carrera);
    void deleteEgresado(Integer IdCarrera);
}
