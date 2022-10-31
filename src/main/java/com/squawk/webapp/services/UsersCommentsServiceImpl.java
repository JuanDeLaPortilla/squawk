package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersComments;
import com.squawk.webapp.repositories.UsersCommentsRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersCommentsServiceImpl implements UsersCommentsService {
    private UsersCommentsRepositoryImpl repositoryJdbc;

    public UsersCommentsServiceImpl(Connection connection) {
        this.repositoryJdbc = new UsersCommentsRepositoryImpl(connection);
    }

    @Override
    public List<UsersComments> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<UsersComments> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(UsersComments uc) {
        try {
            repositoryJdbc.add(uc);
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
