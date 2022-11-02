package com.squawk.webapp.services;

import com.squawk.webapp.models.User;
import com.squawk.webapp.repositories.UserRepository;
import com.squawk.webapp.repositories.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepository<User> repositoryJdbc;

    public UserServiceImpl(Connection connection) {
        this.repositoryJdbc = new UserRepositoryImpl(connection);
    }

    @Override
    public List<User> findAll() {
        try {
            return repositoryJdbc.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void add(User user) {
        try {
            repositoryJdbc.add(user);
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

    @Override
    public void uploadPicture(Long id, String img) {
        try{
            repositoryJdbc.uploadPicture(id, img);
        }catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<User> login(String email, String password) {
        try{
            return Optional.ofNullable(repositoryJdbc.login(email, password));
        } catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
