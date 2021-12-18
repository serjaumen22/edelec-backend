package com.example.edelec.validation;

import com.example.edelec.entitys.Respuesta;
import com.example.edelec.exception.IncorrectResourceRequestException;

public class RespuestaValidator {

    public static void validateBase(Respuesta respuesta){
        if(respuesta.getContenidoRespuesta()==null || respuesta.getContenidoRespuesta().trim().isEmpty()){
            throw  new IncorrectResourceRequestException("Esta pregunta no tiene description");
        }
    }

    public static void validate(Respuesta respuesta){
        if (respuesta.getSelect()==null){
            throw  new IncorrectResourceRequestException("Esta pregunta se hiso");
        }
        if (respuesta.getCarrera()==null){
            throw  new IncorrectResourceRequestException("No tiene carreras realcionadas");
        }
    }

}
