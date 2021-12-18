package com.example.edelec.repositories;

import com.example.edelec.entitys.Respuesta;
import com.example.edelec.entitys.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {

    @Query("FROM Sede s WHERE s.ubicacion=: busqueda")
    List<Sede> buscarPorUbicacion(@Param("busqueda") String busqueda);

    @Query("FROM Sede s WHERE s.universidad.name=: nombre")
    List<Sede> buscarPorNombre(@Param("nombre") String nombre);


}
