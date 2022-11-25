package com.squawk.webapp.services;

import com.squawk.webapp.models.Cuack;

import java.util.List;
import java.util.Optional;

public interface CuackService {
    List<Cuack> findAll();
    List<Cuack> findAllLiked(Long id);
    List<Cuack> findTopMonthly();
    List<Cuack> findByUserId(Long id);
    List<Cuack> findByUserIdLiked (Long userId, Long sessionId);
    Optional<Cuack> findById(Long id);
    Optional<Cuack> findByIdLiked(Long cuackId, Long sessionId);
    void add(Cuack cuack);
    void delete(Long id);
    void uploadPicture(Long id, String img);
}