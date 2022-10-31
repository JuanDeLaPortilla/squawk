package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeCuack;

import java.util.List;
import java.util.Optional;

public interface LikeCuackService {
    List<LikeCuack> findAll();

    Optional<LikeCuack> findById(Long id);

    void add(LikeCuack lc);

    void delete(Long id);


}
