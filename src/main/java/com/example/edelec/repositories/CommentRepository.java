package com.example.edelec.repositories;

import com.example.edelec.entitys.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer> {


public List<Comments> findByUniversidadIdUniversidad(Integer Id);


}
