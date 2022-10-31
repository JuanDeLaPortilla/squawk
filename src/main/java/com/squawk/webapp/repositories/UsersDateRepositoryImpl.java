package com.squawk.webapp.repositories;


import com.squawk.webapp.models.UsersDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDateRepositoryImpl implements Repository<UsersDate> {
    private Connection conn;

    public UsersDateRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<UsersDate> findAll() throws SQLException {
        List<UsersDate> uta = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_date")) {
            while (rs.next()) {
                UsersDate u = getUsersDate(rs);

                uta.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uta;
    }


    @Override
    public UsersDate findById(Long id) throws SQLException {
        UsersDate ud = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users_date WHERE user_id= ? AND date_id = ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    ud = getUsersDate(rs);
                }
            }
        }
        return ud;
    }

    @Override
    public void add(UsersDate ud) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users_date WHERE user_id=? AND date_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static UsersDate getUsersDate(ResultSet rs) throws SQLException {
        UsersDate ud = new UsersDate();
        ud.setUserID(rs.getLong("user_id"));
        ud.setDateID(rs.getLong("date_id"));
        return ud;
    }
}
