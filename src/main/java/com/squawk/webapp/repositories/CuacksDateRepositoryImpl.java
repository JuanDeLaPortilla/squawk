package com.squawk.webapp.repositories;


import com.squawk.webapp.models.CuacksDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuacksDateRepositoryImpl implements Repository<CuacksDate> {
    private Connection conn;

    public CuacksDateRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<CuacksDate> findAll() throws SQLException {
        List<CuacksDate> cd = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cuacks_date")) {
            while (rs.next()) {
                CuacksDate c = getCuacksDate(rs);

                cd.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cd;
    }


    @Override
    public CuacksDate findById(Long id) throws SQLException {
        CuacksDate cd = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cuacks_date WHERE cuack_id= ? AND date_id = ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    cd = getCuacksDate(rs);
                }
            }
        }
        return cd;
    }

    @Override
    public void add(CuacksDate cd) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM cuacks_date WHERE cuack_id=? AND date_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static CuacksDate getCuacksDate(ResultSet rs) throws SQLException {
        CuacksDate ud = new CuacksDate();
        ud.setCuackID(rs.getLong("cuack_id"));
        ud.setDateID(rs.getLong("date_id"));
        return ud;
    }
}