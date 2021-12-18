package com.example.edelec.services;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Universidad;

import java.util.List;

public interface UniversidadService {

    Universidad createUniversidad(Universidad universidad);
    List<Universidad> getAllUniversidad();
    List<Universidad> getUniversidadByname(String name);
    Universidad updateUniversidad(Universidad universidad);
    void deleteUniversidad(String name);
    void deleteUniversidadById(Integer idUniversidad);

}
