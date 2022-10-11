package com.squawk.webapp.services;

import com.squawk.webapp.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    void add(User user);

    void delete(Long id);

    Optional<User> login(String email, String password);
}
