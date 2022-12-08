package com.squawk.webapp.services;

import com.squawk.webapp.models.Cuack;

import java.util.List;
import java.util.Optional;

public interface CuackService {
    List<Cuack> findAll();
    List<Cuack> findTopMonthly();
    List<Cuack> findByUserId(Long id);
    List<Cuack> findByTagId(Long id);
    List<Object> findByMonth();
    Optional<Cuack> findById(Long id);
    Integer countMonthlyCuacks();
    void add(Cuack cuack);
    void delete(Long id);
}