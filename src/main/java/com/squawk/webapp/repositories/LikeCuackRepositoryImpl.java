package com.squawk.webapp.repositories;


import com.squawk.webapp.models.LikeCuack;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeCuackRepositoryImpl implements Repository<LikeCuack> {
    private Connection conn;

    public LikeCuackRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<LikeCuack> findAll() throws SQLException {
        List<LikeCuack> lc = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM like_cuack")) {
            while (rs.next()) {
                LikeCuack l = getLikeCuack(rs);

                lc.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lc;
    }


    @Override
    public LikeCuack findById(Long id) throws SQLException {
        LikeCuack lc = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM like_cuack WHERE like_cuack_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    lc = getLikeCuack(rs);
                }
            }
        }
        return lc;
    }

    @Override
    public void add(LikeCuack lc) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM like_cuack WHERE like_cuack_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static LikeCuack getLikeCuack(ResultSet rs) throws SQLException {
        LikeCuack t = new LikeCuack();
        t.setLikeCuackID(rs.getLong("like_cuack_id"));
        t.setUserID(rs.getLong("user_id"));
        t.setCuackID(rs.getLong("cuack_id"));
        return t;
    }
}
