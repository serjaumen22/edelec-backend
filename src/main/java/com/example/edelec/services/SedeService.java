package com.example.edelec.services;

import com.example.edelec.entitys.Egresado;
import com.example.edelec.entitys.Sede;

import java.util.List;

public interface SedeService {

    Sede createSede(Sede sede);
    List<Sede> getAllSedes();
    List<Sede> getSedesNombre(String nombre);
    List<Sede> getSedesUbicacion(String ubicacion);
    Sede updateSede(Sede sede);
    void deleteSede(Integer IdSede);
}
