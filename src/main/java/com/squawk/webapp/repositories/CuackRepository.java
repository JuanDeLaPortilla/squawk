package com.squawk.webapp.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CuackRepository<T>{
    List<T> findAll() throws SQLException;
    List<T> findAllLiked(Long id) throws SQLException;
    List<T> findTopMonthly() throws SQLException;
    List<T> findByUserId(Long id) throws SQLException;
    List<T> findByUserIdLiked(Long userId, Long sessionId) throws SQLException;
    T findById(Long id) throws SQLException;
    T findByIdLiked(Long cuackId, Long sessionId) throws SQLException;
    void add(T t) throws SQLException;
    void uploadPicture(Long id, String img) throws SQLException;
    void delete(Long id) throws SQLException;
}
