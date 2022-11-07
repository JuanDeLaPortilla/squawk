package com.squawk.webapp.services;

import com.squawk.webapp.models.Cuack;

import java.util.List;
import java.util.Optional;

public interface CuackService {
    List<Cuack> findAll();

    Optional<Cuack> findById(Long id);

    void add(Cuack cuack);

    void delete(Long id);

    void uploadPicture(Long id, String img);
}