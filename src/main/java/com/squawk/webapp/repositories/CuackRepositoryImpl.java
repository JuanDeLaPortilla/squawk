package com.squawk.webapp.repositories;

import com.squawk.webapp.models.User;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.Tag;
import com.squawk.webapp.util.Util;

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
        List<Cuack> cuacks = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select c.cuack_id, c.content, c.img, c.product_url," +
                     " c.rating, c.status as cuack_status, c.title, c.creation_date as " +
                     "cuack_creation_date, c.is_edited, t.tag_id, t.description as tag,u.* " +
                     "from cuacks as c inner join tags as t inner join users as u on c.tag_id = " +
                     "t.tag_id and u.user_id = c.user_id order by c.creation_date desc")) {
            while (rs.next()) {
                Cuack c = getCuack(rs);
                cuacks.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuacks;
    }


    @Override
    public Cuack findById(Long id) throws SQLException {
        Cuack cuack = null;
        try(PreparedStatement stmt = conn.prepareStatement("select c.cuack_id, c.content, " +
                "c.img, c.product_url, c.rating, c.status as cuack_status, c.title, c.creation_date " +
                "as cuack_creation_date, c.is_edited, t.tag_id, t.description as tag,u.* from " +
                "cuacks as c inner join tags as t inner join users as u on c.tag_id = t.tag_id and " +
                "u.user_id = c.user_id where c.cuack_id=? order by c.creation_date desc")) {
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
    public List<Cuack> findTopMonthly() throws SQLException {
        List<Cuack> cuacks = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select c.cuack_id, c.content, c.img, c.product_url," +
                     " c.rating, c.status as cuack_status, c.title, c.creation_date as" +
                     " cuack_creation_date, c.is_edited, t.tag_id, t.description as tag,u.*" +
                     " from cuacks as c inner join tags as t inner join users as u on c.tag_id" +
                     " = t.tag_id and u.user_id = c.user_id where month(c.creation_date)" +
                     " = month(CURRENT_DATE) and year(c.creation_date) = year(CURRENT_DATE)" +
                     " order by c.rating desc LIMIT 6")) {
            while (rs.next()) {
                Cuack c = getCuack(rs);
                cuacks.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuacks;
    }

    @Override
    public List<Cuack> findByUserId(Long id) throws SQLException {
        List<Cuack> cuack = new ArrayList<>();
        try(PreparedStatement stmt = conn.prepareStatement("select c.cuack_id, c.content, " +
                "c.img, c.product_url, c.rating, c.status as cuack_status, c.title, c.creation_date " +
                "as cuack_creation_date, c.is_edited, t.tag_id, t.description as tag,u.* from " +
                "cuacks as c inner join tags as t inner join users as u on c.tag_id = t.tag_id and " +
                "u.user_id = c.user_id where u.user_id=? order by c.creation_date desc")) {
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    Cuack c = getCuack(rs);
                    cuack.add(c);
                }
            }
        }
        return cuack;
    }

    @Override
    public void add(Cuack cuack) throws SQLException {
        String sql;
        if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
            sql = "UPDATE cuacks SET user_id=?,tag_id=?,content=?,img=?,product_url=?,rating=?,status=?,title=?,is_edited=? WHERE cuack_id=?";
        } else {
            sql = "INSERT INTO cuacks (user_id,tag_id,content,img,product_url,rating,status,title,is_edited,creation_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cuack.getUser().getId());
            stmt.setLong(2, cuack.getTag().getTagID());
            stmt.setString(3, cuack.getContent());
            stmt.setString(4, cuack.getImg());
            stmt.setString(5, cuack.getUrl());
            stmt.setDouble(6, cuack.getRating());
            stmt.setInt(7, cuack.getStatus());
            stmt.setString(8, cuack.getTitle());
            stmt.setInt(9, cuack.isEdited());
            if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
                stmt.setLong(10, cuack.getCuackID());
            } else {
                stmt.setTimestamp(10,Timestamp.valueOf(cuack.getCreationDate()));
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
        c.setContent(rs.getString("content"));
        c.setImg(rs.getString("img"));
        c.setUrl(rs.getString("product_url"));
        c.setRating(rs.getDouble("rating"));
        c.setStatus(rs.getInt("cuack_status"));
        c.setTitle(rs.getString("title"));
        c.setCreationDate(rs.getTimestamp("creation_date").toLocalDateTime());
        c.setEdited(rs.getInt("is_edited"));

        Tag t = new Tag();
        t.setTagID(rs.getLong("tag_id"));
        t.setDesc(rs.getString("tag"));
        c.setTag(t);

        User u = Util.getUser(rs);
        c.setUser(u);
        return c;
    }

}