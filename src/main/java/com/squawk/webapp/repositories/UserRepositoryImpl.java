package com.squawk.webapp.repositories;

import com.squawk.webapp.models.User;
import com.squawk.webapp.util.Util;

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
    public List<User> findStaffLazy() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nickname, profile_picture, email from users where user_type=3")) {
            while (rs.next()) {
                User u = new User();
                u.setName(rs.getString("nickname"));
                u.setImg(rs.getString("profile_picture"));
                u.setEmail(rs.getString("email"));

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
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id= ?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = getUser(rs);
                }
            }
        }
        return user;
    }

    @Override
    public List<Object> findByMonth() throws SQLException {
        List<Object> findByMonth = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        int user;
        String creation_month;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT\n" +
                     "    DATE_FORMAT(creation_date, '%M-%Y') AS creation_month,\n" +
                     "    COUNT(*) AS users\n" +
                     "FROM users\n" +
                     "where year(creation_date) = year(current_date)\n" +
                     "GROUP BY\n" +
                     "    MONTH(creation_date),\n" +
                     "    YEAR(creation_date)")) {
            while (rs.next()) {
                user = rs.getInt("users");
                data.add(user);
                creation_month = rs.getString("creation_month");
                labels.add(creation_month);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        findByMonth.add(labels);
        findByMonth.add(data);

        return findByMonth;
    }

    @Override
    public int countMonthlyUsers() throws SQLException {
        int users = 0;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) as users from users where month(creation_date)=month(current_date) and year(creation_date)=year(current_date)")) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    users = rs.getInt("users");
                }
            }
        }
        return users;
    }

    @Override
    public int countAllUsers() throws SQLException {
        int users = 0;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) as users from users")) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    users = rs.getInt("users");
                }
            }
        }
        return users;
    }

    @Override
    public int countActiveUsers() throws SQLException {
        int users = 0;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) as users from users where status=1")) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    users = rs.getInt("users");
                }
            }
        }
        return users;
    }

    @Override
    public void add(User user) throws SQLException {
        String sql;
        if (user.getId() != null && user.getId() > 0) {
            sql = "UPDATE users SET nickname=?,password=?,email=?,user_type=?,status=?,birthday=? WHERE user_id=?";
        } else {
            sql = "INSERT INTO users (nickname,password,email,user_type,status,birthday,creation_date) VALUES (?,?,?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getType());
            stmt.setInt(5, user.getStatus());
            stmt.setDate(6, Date.valueOf(user.getBirthday()));
            if (user.getId() != null && user.getId() > 0) {
                stmt.setLong(7, user.getId());
            } else {
                stmt.setDate(7, Date.valueOf(user.getCreationDate()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
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
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = getUser(rs);
                }
            }
        }
        return user;
    }

    @Override
    public void uploadPicture(Long id, String img) throws SQLException {
        String sql;
        sql = "UPDATE users SET profile_picture=? WHERE user_id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, img);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    private static User getUser(ResultSet rs) throws SQLException {
        User u = Util.getUser(rs);
        return u;
    }
}
