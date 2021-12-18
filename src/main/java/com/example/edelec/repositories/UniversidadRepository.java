package com.example.edelec.repositories;

import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {

    @Query("FROM Universidad u WHERE lower(u.name) LIKE %:name% ")
    List<Universidad> buscarUniversidad(@Param("name") String name);

    @Query("FROM Universidad u WHERE lower(u.name) =: name ")
    Universidad buscarUniversidadByName(@Param("name") String name);
}
