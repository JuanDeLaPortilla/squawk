package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersDate;

import java.util.List;
import java.util.Optional;

public interface UsersDateService {
    List<UsersDate> findAll();

    Optional<UsersDate> findById(Long id);

    void add(UsersDate ud);

    void delete(Long id);


}
