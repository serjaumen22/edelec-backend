package com.example.edelec.repositories;

import com.example.edelec.entitys.Egresado;
import com.example.edelec.entitys.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EgresadoRepository extends JpaRepository<Egresado, Integer> {

    @Query("FROM Egresado e WHERE e.carrera.nombreCarrera=:nombreCarrera AND e.sede.universidad.name=:nombreUniversidad")
    List<Egresado> buscarPornombreCarrera(@Param("nombreCarrera") String nombreCarrera, @Param("nombreUniversidad") String nombreUniversidad);

}
