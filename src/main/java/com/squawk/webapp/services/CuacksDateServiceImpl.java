package com.squawk.webapp.services;

import com.squawk.webapp.models.CuacksDate;
import com.squawk.webapp.repositories.CuacksDateRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CuacksDateServiceImpl implements CuacksDateService {
    private CuacksDateRepositoryImpl repositoryJdbc;

    public CuacksDateServiceImpl(Connection connection) {
        this.repositoryJdbc = new CuacksDateRepositoryImpl(connection);
    }

    @Override
    public List<CuacksDate> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<CuacksDate> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(CuacksDate cd) {
        try {
            repositoryJdbc.add(cd);
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
