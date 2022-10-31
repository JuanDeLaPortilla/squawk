package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeComment;

import java.util.List;
import java.util.Optional;

public interface LikeCommentService {
    List<LikeComment> findAll();

    Optional<LikeComment> findById(Long id);

    void add(LikeComment lc);

    void delete(Long id);


}
