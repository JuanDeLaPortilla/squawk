package com.squawk.webapp.services;

import com.squawk.webapp.models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<User> findStaffLazy();
    List<Object> findByMonth();
    Optional<User> findById(Long id);
    Integer countMonthlyUsers();
    Integer countAllUsers();
    Integer countActiveUsers();
    void add(User user);
    void delete(Long id);
    void activate(Long id);
    void uploadPicture(Long id, String img);
    Optional<User> login(String email, String password);
}
