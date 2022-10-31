package com.squawk.webapp.services;

import com.squawk.webapp.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll();

    Optional<Comment> findById(Long id);

    void add(Comment comment);

    void delete(Long id);


}
