package com.squawk.webapp.services;

import com.squawk.webapp.models.countByMonth;
import com.squawk.webapp.repositories.countByMonthRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class countByMonthServiceImpl implements countByMonthService {
    private countByMonthRepositoryImpl repositoryJdbc;

    public countByMonthServiceImpl(Connection connection) {
        this.repositoryJdbc = new countByMonthRepositoryImpl(connection);
    }
    
    @Override
    public List<countByMonth> findCantCuacks() {
        try {
            return repositoryJdbc.findCantCuacks();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
    
    @Override
    public List<countByMonth> findCantUsers() {
        try {
            return repositoryJdbc.findCantUsers();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}