package com.squawk.webapp.repositories;

import com.squawk.webapp.models.User;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuackRepositoryImpl implements CuackRepository<Cuack> {
    private Connection conn;

    public CuackRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Cuack> findAll() throws SQLException {
        List<Cuack> cuack = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.*, t.description as tag FROM cuacks as c " +
                     "inner join tags as t on (c.tag_id = t.tag_id)")) {
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
        try(PreparedStatement stmt = conn.prepareStatement("SELECT c.*, t.description as tag FROM cuacks as c " +
                "inner join tags as t on (c.tag_id = t.tag_id) where c.cuack_id = ?")) {
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
        String sql;
        if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
            sql = "UPDATE cuacks SET tag_id=?,description=?,img=?,product_url=?,rating=?,status=?,title=?,price_range=?,creation_date=?,is_edited=? WHERE cuack_id=?";
        } else {
            sql = "INSERT INTO cuacks (tag_id,description,img,product_url,rating,status,title,price_range,creation_date,is_edited) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cuack.getTag().getTagID());
            stmt.setString(2, cuack.getDesc());
            stmt.setString(3, cuack.getImg());
            stmt.setString(4, cuack.getUrl());
            stmt.setDouble(5, cuack.getRating());
            stmt.setInt(6, cuack.getStatus());
            stmt.setString(7, cuack.getTitle());
            stmt.setDouble(8, cuack.getPrice());
            stmt.setInt(9, cuack.isEdited());
            if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
                stmt.setLong(10, cuack.getCuackID());
            } else {
                stmt.setDate(10, Date.valueOf(cuack.getCreationDate()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM cuacks WHERE cuack_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    
    @Override
    public void uploadPicture(Long id, String img) throws SQLException {
        String sql;
        sql = "UPDATE cuacks SET img=? WHERE cuack_id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, img);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }
    
    private static Cuack getCuack(ResultSet rs) throws SQLException {
        Cuack c = new Cuack();
        c.setCuackID(rs.getLong("cuack_id"));

        Tag t = new Tag();
        t.setTagID(rs.getLong("tag_id"));
        t.setDesc(rs.getString("tag"));
        c.setTag(t);

        c.setDesc(rs.getString("description"));
        c.setImg(rs.getString("img"));
        c.setUrl(rs.getString("product_url"));
        c.setRating(rs.getDouble("rating"));
        c.setStatus(rs.getInt("status"));
        c.setTitle(rs.getString("title"));
        c.setPrice(rs.getDouble("price_range"));
        c.setCreationDate(rs.getDate("creation_date").toLocalDate());
        c.setEdited(rs.getInt("is_edited"));
        return c;
    }

}