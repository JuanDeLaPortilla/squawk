package com.squawk.webapp.repositories;


import com.squawk.webapp.models.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateRepositoryImpl implements Repository<Date> {
    private Connection conn;

    public DateRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Date> findAll() throws SQLException {
        List<Date> date = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM date")) {
            while (rs.next()) {
                Date d = getDate(rs);

                date.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return date;
    }


    @Override
    public Date findById(Long id) throws SQLException {
        Date date = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM date WHERE date_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    date = getDate(rs);
                }
            }
        }
        return date;
    }

    @Override
    public void add(Date date) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM date WHERE date_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static Date getDate(ResultSet rs) throws SQLException {
        Date d = new Date();
        d.setDateID(rs.getLong("date_id"));
        d.setMonth(rs.getInt("month"));
        d.setYear(rs.getInt("year"));
        return d;
    }
}
