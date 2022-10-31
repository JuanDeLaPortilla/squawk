package com.squawk.webapp.services;

import com.squawk.webapp.models.Comment;
import com.squawk.webapp.repositories.CommentRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    private CommentRepositoryImpl repositoryJdbc;

    public CommentServiceImpl(Connection connection) {
        this.repositoryJdbc = new CommentRepositoryImpl(connection);
    }

    @Override
    public List<Comment> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Comment> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(Comment comment) {
        try {
            repositoryJdbc.add(comment);
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
