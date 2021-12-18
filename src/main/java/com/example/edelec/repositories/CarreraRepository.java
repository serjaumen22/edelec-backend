package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("Select c FROM  Carrera c WHERE c.nombreCarrera=:nombre")
    List<Carrera> buscarCarrera(@Param("nombre") String nombreCarrera);

    @Query("Select c FROM  Carrera c WHERE c.nombreCarrera=:nombre")
    Carrera buscarUna(@Param("nombre") String nombreCarrera);

    @Query("Select c FROM Carrera c WHERE c.descripcionDeCarrera=:name")
    List<Carrera> BuscarDescripcionCarrera(@Param("name") String name);

    @Query("Select c FROM Carrera c WHERE c.salarioPromedio=:name")
    List<Carrera> buscarCarreraporSalario(@Param("name") String name);

    @Query("Select c FROM Carrera c WHERE c.tasaDeEmpleabilidad=:name")
    List<Carrera> BuscarPorTasa(@Param("name") String name);

    @Query("FROM Carrera c WHERE lower(c.nombreCarrera) LIKE %:name% ")
    List<Carrera> buscarCarreraNombre(@Param("name") String name);

}
