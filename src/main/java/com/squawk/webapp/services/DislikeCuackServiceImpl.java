package com.squawk.webapp.services;

import com.squawk.webapp.repositories.DislikeCuackRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class DislikeCuackServiceImpl implements DislikeCuackService {
    private DislikeCuackRepositoryImpl repository;

    public DislikeCuackServiceImpl(Connection conn) {
        this.repository = new DislikeCuackRepositoryImpl(conn);
    }

    @Override
    public String add(Long cuackId, Long userId) {
        try {
            return repository.add(cuackId, userId);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Integer countDislikesOnCuacks(Long cuackId) {
        try {
            return repository.countDislikesOnCuacks(cuackId);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Boolean isDislikedByUser(Long cuackId, Long userId) {
        try {
            return repository.isDislikedByUser(cuackId,userId);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public String delete(Long cuackId, Long userId) {
        try {
            return repository.delete(cuackId,userId);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
