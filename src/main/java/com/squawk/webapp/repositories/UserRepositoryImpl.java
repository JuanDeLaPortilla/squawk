package com.squawk.webapp.repositories;

import com.squawk.webapp.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository<User> {
    private Connection conn;

    public UserRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                User u = getUser(rs);

                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public User findById(Long id) throws SQLException {
        User user = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    user = getUser(rs);
                }
            }
        }
        return user;
    }

    @Override
    public void add(User user) throws SQLException {
        String sql;
        if(user.getId() != null && user.getId() > 0){
            sql = "UPDATE users SET nickname=?,password=?,email=?,profile_picture=?,user_type=?,status=?,birthday=? WHERE user_id=?";
        }else{
            sql = "INSERT INTO users (nickname,password,email,profile_picture,user_type,status,birthday,creation_date) VALUES (?,?,?,?,?,?,?,?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user.getName());
            stmt.setString(2,user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getImg());
            stmt.setInt(5,user.getType());
            stmt.setInt(6,user.getStatus());
            stmt.setDate(7,Date.valueOf(user.getBirthday()));
            if(user.getId() != null && user.getId() > 0) {
                stmt.setLong(8,user.getId());
            }else{
                stmt.setDate(8,Date.valueOf(user.getCreationDate()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }

    @Override
    public User login(String email, String password) throws SQLException {
        User user = null;

        String sql = "SELECT * FROM users WHERE email=? and password=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    user = getUser(rs);
                }
            }
        }
        return user;
    }

    private static User getUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getLong("user_id"));
        u.setName(rs.getString("nickname"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        u.setImg(rs.getString("profile_picture"));
        u.setType(rs.getInt("user_type"));
        u.setStatus(rs.getInt("status"));
        u.setBirthday(rs.getDate("birthday").toLocalDate());
        u.setCreationDate(rs.getDate("creation_date").toLocalDate());
        return u;
    }
}
