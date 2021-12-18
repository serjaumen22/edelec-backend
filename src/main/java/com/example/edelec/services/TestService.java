package com.example.edelec.services;

import com.example.edelec.entitys.*;

import java.util.List;

public interface TestService {
    Test createTest(Test test);
    Test crearTestBase(Test test);
    Test getTestById(Integer IdTest);
    List<Test> ObtenerTestbyUser(String username);
    String obtenerResultados(Integer id);
    List<Carrera> carrerasRelacionadas(Integer id);
    List<Pregunta> getPreguntasBase();
    Test replaceTestBase(Test test);


    void deleteTest(Integer IdTest);
    List<Test> getAllTest();
}
