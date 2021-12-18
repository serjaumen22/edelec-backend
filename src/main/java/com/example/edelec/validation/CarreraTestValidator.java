package com.example.edelec.validation;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Respuesta;
import com.example.edelec.exception.IncorrectResourceRequestException;

public class CarreraTestValidator {
    public static void validate(Carrera carrera){
        if (carrera.getIdCarrera()==null){
            throw  new IncorrectResourceRequestException("Esta carrera sin id");
        }
    }
}
