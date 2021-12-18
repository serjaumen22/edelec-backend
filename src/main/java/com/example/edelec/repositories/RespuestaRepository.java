package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

    @Query("SELECT r FROM  Respuesta r WHERE r.contenidoRespuesta=:contenido")
    Respuesta buscarRespusta(@Param("contenido") String contennt);

    @Query("SELECT r FROM Respuesta r WHERE r.pregunta.idPregunta=:pregunta")
    List<Respuesta> RespuestaByPregunta(@Param("pregunta") Integer idPregunta);

}
