package com.example.edelec.services;
import com.example.edelec.entitys.Carrera;

import java.util.List;

public interface CarreraService {
    Carrera createCarrera(Carrera carrera);
    List<Carrera> getAllCarrera();
    List<Carrera> getCarreraByName(String name);
    Carrera getCarreraById(Integer idCarrera);
    Carrera updateCarrera(Carrera carrera);
    void deleteCarrera(Integer IdCarrera);
}
