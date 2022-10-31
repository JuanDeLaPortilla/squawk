package com.squawk.webapp.services;

import com.squawk.webapp.models.Tag;
import com.squawk.webapp.repositories.TagRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TagServiceImpl implements TagService {
    private TagRepositoryImpl repositoryJdbc;

    public TagServiceImpl(Connection connection) {
        this.repositoryJdbc = new TagRepositoryImpl(connection);
    }

    @Override
    public List<Tag> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Tag> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(Tag tag) {
        try {
            repositoryJdbc.add(tag);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repositoryJdbc.delete(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
