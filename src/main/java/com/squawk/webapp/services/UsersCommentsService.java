package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersComments;

import java.util.List;
import java.util.Optional;

public interface UsersCommentsService {
    List<UsersComments> findAll();

    Optional<UsersComments> findById(Long id);

    void add(UsersComments uc);

    void delete(Long id);


}
