package com.example.edelec.services.impl;

import com.example.edelec.entitys.Comments;
import com.example.edelec.entitys.Universidad;
import com.example.edelec.entitys.Usuario;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.CommentRepository;
import com.example.edelec.repositories.UniversidadRepository;
import com.example.edelec.repositories.UsuarioRepository;
import com.example.edelec.services.CommentService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
private final CommentRepository commentRepository;
private final UsuarioRepository usuarioRepository;
private final UniversidadRepository universidadRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UsuarioRepository usuarioRepository, UniversidadRepository universidadRepository) {
        this.commentRepository = commentRepository;
        this.usuarioRepository = usuarioRepository;
        this.universidadRepository = universidadRepository;
    }

    @Override
    public Comments createComment(Comments comment) {
        Usuario usuario=usuarioRepository.findById(comment.getUser().getIdUsuario())
                .orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario"));
        Universidad universidad =universidadRepository.findById(comment.getUniversidad().getIdUniversidad())
                .orElseThrow(()-> new ResourceNotFoundException("No existe la universidad"));
        comment.setTiempo(LocalDateTime.now());
        comment.setUser(usuario);
        comment.setUniversidad(universidad);
        return commentRepository.save(comment);
    }

    @Override
    public Comments updateComment(Comments comment) {
           Comments  commentFromDb=commentRepository.findById(comment.getIdComentario())
                   .orElse(new Comments());
           commentFromDb.setContenido(comment.getContenido());
           commentFromDb.setVotes(comment.getVotes());
           commentFromDb.setTiempo(LocalDateTime.now());
        Usuario usuario=usuarioRepository.findById(comment.getUser().getIdUsuario())
                .orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario"));
        Universidad universidad =universidadRepository.findById(comment.getUniversidad().getIdUniversidad())
                .orElseThrow(()-> new ResourceNotFoundException("No existe la universidad"));
        commentFromDb.setUser(usuario);
        commentFromDb.setUniversidad(universidad);
           return commentRepository.save(commentFromDb);

    }

    @Override
    public List<Comments> listComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comments> getCommentsByUniversidadId(Integer Id) {
        List<Comments> comments=commentRepository.findByUniversidadIdUniversidad(Id);
        return comments;
    }

    @Override
    public Comments deleteComment(Integer id) {
        Comments  commentFromDb =commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe el comentario a borrar"));
        commentRepository.deleteById(commentFromDb.getIdComentario());
        return commentFromDb;
    }
}


