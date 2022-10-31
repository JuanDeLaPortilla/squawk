package com.squawk.webapp.services;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.repositories.CuackRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CuackServiceImpl implements CuackService {
    private CuackRepositoryImpl repositoryJdbc;

    public CuackServiceImpl(Connection connection) {
        this.repositoryJdbc = new CuackRepositoryImpl(connection);
    }

    @Override
    public List<Cuack> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Cuack> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(Cuack cuack) {
        try {
            repositoryJdbc.add(cuack);
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
