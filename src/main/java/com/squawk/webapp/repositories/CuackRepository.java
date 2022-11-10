package com.squawk.webapp.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CuackRepository<T>{
    List<T> findAll() throws SQLException;
    List<T> findByUserId(Long id) throws SQLException;
    T findById(Long id) throws SQLException;
    void add(T t) throws SQLException;
    void uploadPicture(Long id, String img) throws SQLException;
    void delete(Long id) throws SQLException;
}
