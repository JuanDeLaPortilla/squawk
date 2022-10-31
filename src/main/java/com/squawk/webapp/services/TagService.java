package com.squawk.webapp.services;

import com.squawk.webapp.models.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAll();

    Optional<Tag> findById(Long id);

    void add(Tag tag);

    void delete(Long id);


}
