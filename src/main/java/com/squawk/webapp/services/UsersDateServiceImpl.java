package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersDate;
import com.squawk.webapp.repositories.UsersDateRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDateServiceImpl implements UsersDateService {
    private UsersDateRepositoryImpl repositoryJdbc;

    public UsersDateServiceImpl(Connection connection) {
        this.repositoryJdbc = new UsersDateRepositoryImpl(connection);
    }

    @Override
    public List<UsersDate> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<UsersDate> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(UsersDate ud) {
        try {
            repositoryJdbc.add(ud);
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
