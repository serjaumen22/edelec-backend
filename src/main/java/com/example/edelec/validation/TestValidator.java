package com.example.edelec.validation;

import com.example.edelec.entitys.Test;
import com.example.edelec.exception.IncorrectResourceRequestException;

public class TestValidator {

    public static void validate(Test test){

        if (test.getUsuario().getIdUsuario()==null){
            throw  new IncorrectResourceRequestException("No tiene usuario del test");
        }
    }

    public static void validateBase(Test test){
        if (test.getPreguntas().isEmpty() || test.getPreguntas()==null){
            throw new IncorrectResourceRequestException("No tiene preguntas");
        }
    }

}
