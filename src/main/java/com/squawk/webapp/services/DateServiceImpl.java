package com.squawk.webapp.services;

import com.squawk.webapp.models.Date;
import com.squawk.webapp.repositories.DateRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DateServiceImpl implements DateService {
    private DateRepositoryImpl repositoryJdbc;

    public DateServiceImpl(Connection connection) {
        this.repositoryJdbc = new DateRepositoryImpl(connection);
    }

    @Override
    public List<Date> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Date> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(Date date) {
        try {
            repositoryJdbc.add(date);
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
