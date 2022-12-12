package com.squawk.webapp.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public interface UserRepository<T>{
    List<T> findAll() throws SQLException;
    List<T> findStaffLazy() throws SQLException;
    List<Object> findByMonth() throws SQLException;
    T findById(Long id) throws SQLException;
    int countMonthlyUsers() throws SQLException;
    int countAllUsers() throws SQLException;
    int countActiveUsers() throws SQLException;
    void add(T t) throws SQLException;
    void uploadPicture(Long id, String img) throws SQLException;
    void delete(Long id) throws SQLException;
    void activate(Long id) throws SQLException;
    T login(String email, String password) throws SQLException;
}
