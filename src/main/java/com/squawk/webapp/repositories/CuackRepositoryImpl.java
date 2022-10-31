package com.squawk.webapp.repositories;


import com.squawk.webapp.models.Cuack;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuackRepositoryImpl implements Repository<Cuack> {
    private Connection conn;

    public CuackRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Cuack> findAll() throws SQLException {
        List<Cuack> cuack = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cuacks")) {
            while (rs.next()) {
                Cuack c = getCuack(rs);

                cuack.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuack;
    }


    @Override
    public Cuack findById(Long id) throws SQLException {
        Cuack cuack = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cuacks WHERE cuack_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    cuack = getCuack(rs);
                }
            }
        }
        return cuack;
    }

    @Override
    public void add(Cuack cuack) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM cuacks WHERE cuack_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static Cuack getCuack(ResultSet rs) throws SQLException {
        Cuack c = new Cuack();
        c.setCuackID(rs.getLong("cuack_id"));
        c.setTagID(rs.getLong("tag_id"));
        c.setDesc(rs.getString("description"));
        c.setImg(rs.getString("img"));
        c.setUrl(rs.getString("product_url"));
        c.setRating(rs.getDouble("rating"));
        c.setStatus(rs.getInt("status"));
        c.setTitle(rs.getString("title"));
        c.setPrice(rs.getDouble("price_range"));
        c.setCreationDate(rs.getDate("creation_date"));
        c.setEdited(rs.getInt("is_edited"));
        return c;
    }

}
