package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersCuacks;

import java.util.List;
import java.util.Optional;

public interface UsersCuacksService {
    List<UsersCuacks> findAll();

    Optional<UsersCuacks> findById(Long id);

    void add(UsersCuacks uc);

    void delete(Long id);


}
