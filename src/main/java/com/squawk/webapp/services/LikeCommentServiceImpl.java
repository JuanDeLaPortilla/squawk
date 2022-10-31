package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeComment;
import com.squawk.webapp.repositories.LikeCommentRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LikeCommentServiceImpl implements LikeCommentService {
    private LikeCommentRepositoryImpl repositoryJdbc;

    public LikeCommentServiceImpl(Connection connection) {
        this.repositoryJdbc = new LikeCommentRepositoryImpl(connection);
    }

    @Override
    public List<LikeComment> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<LikeComment> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(LikeComment lc) {
        try {
            repositoryJdbc.add(lc);
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
