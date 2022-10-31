package com.squawk.webapp.services;

import com.squawk.webapp.models.Date;

import java.util.List;
import java.util.Optional;

public interface DateService {
    List<Date> findAll();

    Optional<Date> findById(Long id);

    void add(Date date);

    void delete(Long id);


}
