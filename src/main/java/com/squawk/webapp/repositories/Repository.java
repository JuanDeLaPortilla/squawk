package com.squawk.webapp.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<T> findAll() throws SQLException;
    T findById(Long id) throws SQLException;
    void add(T t) throws SQLException;
    void delete(Long id) throws SQLException;
}
