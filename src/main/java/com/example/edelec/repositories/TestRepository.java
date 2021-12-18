package com.example.edelec.repositories;

import com.example.edelec.entitys.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    @Query("select t FROM  Test t WHERE t.idTest=:idTest")
    Test getById(@Param("idTest") String idTest);

    @Query("select t FROM  Test t WHERE t.usuario.userName=:usernaame")
    List<Test> getTestByUser(@Param("usernaame") String username);

}
