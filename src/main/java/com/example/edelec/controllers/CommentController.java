package com.example.edelec.controllers;

import com.example.edelec.entitys.Comments;
import com.example.edelec.services.CommentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<List<Comments>>  getAllCommentsById(@PathVariable Integer id){
        List<Comments> comments= commentService.getCommentsByUniversidadId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comments> createComment(@RequestBody Comments comment){
        Comments commentNew =commentService.createComment(comment);
        return new ResponseEntity<>(commentNew, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Comments> updateComment(@RequestBody Comments comment){
        Comments commentUpdate=commentService.updateComment(comment);
        return new ResponseEntity<>(commentUpdate, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Comments>>  getAllComments(){
        List<Comments> comments= commentService.listComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Comments>  deleteComment(@PathVariable Integer id){
        Comments comments= commentService.deleteComment(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
