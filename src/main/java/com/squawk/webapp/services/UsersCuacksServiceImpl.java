package com.squawk.webapp.services;

import com.squawk.webapp.models.UsersCuacks;
import com.squawk.webapp.repositories.UsersCuacksRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersCuacksServiceImpl implements UsersCuacksService {
    private UsersCuacksRepositoryImpl repositoryJdbc;

    public UsersCuacksServiceImpl(Connection connection) {
        this.repositoryJdbc = new UsersCuacksRepositoryImpl(connection);
    }

    @Override
    public List<UsersCuacks> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<UsersCuacks> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(UsersCuacks uc) {
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
