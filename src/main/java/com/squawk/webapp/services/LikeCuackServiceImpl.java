package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeCuack;
import com.squawk.webapp.repositories.LikeCuackRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class LikeCuackServiceImpl implements LikeCuackService {
    private LikeCuackRepositoryImpl repository;

    public LikeCuackServiceImpl(Connection conn) {
        this.repository = new LikeCuackRepositoryImpl(conn);
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
    public Integer countLikesOnCuacks(Long cuackId) {
        try {
            return repository.countLikesOnCuacks(cuackId);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Boolean isLikedByUser(Long cuackId, Long userId) {
        try {
            return repository.isLikedByUser(cuackId,userId);
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
