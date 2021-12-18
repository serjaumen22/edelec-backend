package com.example.edelec.services;


import com.example.edelec.entitys.Comments;

import java.util.List;

public interface CommentService {

    Comments createComment(Comments comment);
    Comments updateComment(Comments comment);
    List<Comments> listComments();
    List<Comments> getCommentsByUniversidadId(Integer Id);
    Comments deleteComment(Integer Id);
}
