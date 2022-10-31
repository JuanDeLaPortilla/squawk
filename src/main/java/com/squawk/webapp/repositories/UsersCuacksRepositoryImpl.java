package com.squawk.webapp.repositories;


import com.squawk.webapp.models.UsersCuacks;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersCuacksRepositoryImpl implements Repository<UsersCuacks> {
    private Connection conn;

    public UsersCuacksRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<UsersCuacks> findAll() throws SQLException {
        List<UsersCuacks> uc = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_cuacks")) {
            while (rs.next()) {
                UsersCuacks u = getUsersCuacks(rs);

                uc.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uc;
    }


    @Override
    public UsersCuacks findById(Long id) throws SQLException {
        UsersCuacks uc = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users_cuacks WHERE user_id= ? AND cuack_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    uc = getUsersCuacks(rs);
                }
            }
        }
        return uc;
    }

    @Override
    public void add(UsersCuacks uc) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users_cuacks WHERE user_id=? AND cuack_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static UsersCuacks getUsersCuacks(ResultSet rs) throws SQLException {
        UsersCuacks uc = new UsersCuacks();
        uc.setUserID(rs.getLong("user_id"));
        uc.setCuackID(rs.getLong("cuack_id"));
        return uc;
    }
}
