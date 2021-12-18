package com.example.edelec.repositories;

import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    @Query("SELECT p FROM  Pregunta p WHERE p.contenido=:contenido")
    Respuesta buscarUniversidad(@Param("contenido") String contennt);

    @Query("SELECT p FROM Pregunta p WHERE p.test.idTest=:test")
    List<Respuesta> BuscarTests(@Param("test") Integer idTest);
}
