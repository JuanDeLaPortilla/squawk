package com.squawk.webapp.services;

import com.squawk.webapp.models.CuacksDate;

import java.util.List;
import java.util.Optional;

public interface CuacksDateService {
    List<CuacksDate> findAll();

    Optional<CuacksDate> findById(Long id);

    void add(CuacksDate cd);

    void delete(Long id);


}
