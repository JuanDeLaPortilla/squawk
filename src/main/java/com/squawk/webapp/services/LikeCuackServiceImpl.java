package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeCuack;
import com.squawk.webapp.repositories.LikeCuackRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LikeCuackServiceImpl implements LikeCuackService {
    private LikeCuackRepositoryImpl repositoryJdbc;

    public LikeCuackServiceImpl(Connection connection) {
        this.repositoryJdbc = new LikeCuackRepositoryImpl(connection);
    }

    @Override
    public List<LikeCuack> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<LikeCuack> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(LikeCuack lc) {
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
