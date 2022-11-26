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
             ResultSet rs = stmt.executeQuery("SELECT c.cuack_id, c.content, c.img, c.product_url," +
                     " c.status AS cuack_status, c.title, c.creation_date AS cuack_creation_date," +
                     " c.is_edited, COUNT(l.cuack_id) AS likes, t.tag_id, t.description AS tag," +
                     " u.* FROM cuacks AS c INNER JOIN tags AS t ON c.tag_id = t.tag_id INNER JOIN" +
                     " users AS u ON c.user_id = u.user_id LEFT JOIN like_cuack AS l ON c.cuack_id" +
                     " = l.cuack_id GROUP BY l.cuack_id ORDER BY cuack_creation_date DESC;")) {
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
    public List<Cuack> findAllLiked(Long id) throws SQLException {
        List<Cuack> cuacks = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.content, c.img, c.product_url," +
                     " c.status AS cuack_status, c.title, c.creation_date AS cuack_creation_date," +
                     " c.is_edited, COUNT(l.cuack_id) AS likes, if((select like_id from like_cuack" +
                     " where user_id = ? and like_cuack.cuack_id = c.cuack_id),1,0) as liked," +
                     " t.tag_id, t.description AS tag, u.* FROM cuacks AS c INNER JOIN tags AS t" +
                     " ON c.tag_id = t.tag_id INNER JOIN users AS u ON c.user_id = u.user_id" +
                     " LEFT JOIN like_cuack AS l ON c.cuack_id = l.cuack_id GROUP BY l.cuack_id" +
                     " ORDER BY cuack_creation_date desc;")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    Cuack c = getCuack(rs);
                    c.setLiked(rs.getInt("liked"));
                    cuacks.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cuacks;
    }
    @Override
    public List<Cuack> findTopMonthly() throws SQLException {
        List<Cuack> cuacks = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.img, u.nickname," +
                " u.profile_picture FROM cuacks AS c INNER JOIN users AS u ON c.user_id = u.user_id" +
                " LEFT JOIN like_cuack AS l ON c.cuack_id = l.cuack_id WHERE MONTH(c.creation_date)" +
                " = MONTH(CURRENT_DATE) AND YEAR(c.creation_date) = YEAR(CURRENT_DATE) GROUP BY" +
                " l.cuack_id ORDER BY COUNT(l.cuack_id) DESC;")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cuack c = new Cuack();
                    c.setCuackID(rs.getLong("cuack_id"));
                    c.setImg(rs.getString("img"));

                    User u = new User();
                    u.setName(rs.getString("nickname"));
                    u.setImg(rs.getString("profile_picture"));
                    c.setUser(u);
                    cuacks.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return cuacks;
    }

    @Override
    public Cuack findById(Long id) throws SQLException {
        Cuack cuack = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.content, c.img," +
                " c.product_url, c.status AS cuack_status, c.title, c.creation_date " +
                "AS cuack_creation_date, c.is_edited, COUNT(l.cuack_id) AS likes, t.tag_id," +
                " t.description AS tag, u.* FROM cuacks AS c INNER JOIN tags AS t ON c.tag_id" +
                " = t.tag_id INNER JOIN users AS u ON c.user_id = u.user_id LEFT JOIN like_cuack" +
                " AS l ON c.cuack_id = l.cuack_id WHERE c.cuack_id = ?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cuack = getCuack(rs);
                }
            }
        }
        return cuack;
    }

    @Override
    public Cuack findByIdLiked(Long cuackId, Long sessionId) throws SQLException {
        Cuack cuack = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.content, c.img," +
                " c.product_url, c.status AS cuack_status, c.title, c.creation_date AS" +
                " cuack_creation_date, c.is_edited, COUNT(l.cuack_id) AS likes, if((select" +
                " like_id from like_cuack where user_id = ? and like_cuack.cuack_id = " +
                "c.cuack_id),1,0) as liked, t.tag_id, t.description AS tag, u.* FROM cuacks" +
                " AS c INNER JOIN tags AS t ON c.tag_id = t.tag_id INNER JOIN users AS" +
                " u ON c.user_id = u.user_id LEFT JOIN like_cuack AS l ON c.cuack_id =" +
                " l.cuack_id where c.cuack_id = ?;")) {
            stmt.setLong(1, sessionId);
            stmt.setLong(2,cuackId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cuack = getCuack(rs);
                    cuack.setLiked(rs.getInt("liked"));
                }
            }
        }
        return cuack;
    }

    @Override
    public List<Cuack> findByUserId(Long id) throws SQLException {
        List<Cuack> cuacks = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.content, c.img," +
                " c.product_url, c.status AS cuack_status, c.title, c.creation_date AS" +
                " cuack_creation_date, c.is_edited, COUNT(l.cuack_id) AS likes, t.tag_id," +
                " t.description AS tag, u.* FROM cuacks AS c INNER JOIN tags AS t " +
                "ON c.tag_id = t.tag_id INNER JOIN users AS u ON c.user_id = u.user_id" +
                " LEFT JOIN like_cuack AS l ON c.cuack_id = l.cuack_id WHERE c.user_id = ?" +
                " GROUP BY l.cuack_id order by cuack_creation_date desc;")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cuack c = getCuack(rs);
                    cuacks.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cuacks;
    }

    @Override
    public List<Cuack> findByUserIdLiked(Long userId, Long sessionId) throws SQLException {
        List<Cuack> cuacks = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT c.cuack_id, c.content, c.img," +
                " c.product_url, c.status AS cuack_status, c.title, c.creation_date AS" +
                " cuack_creation_date, c.is_edited, COUNT(l.cuack_id) AS likes, " +
                "if((select like_id from like_cuack where user_id = ? and like_cuack.cuack_id" +
                " = c.cuack_id),1,0) as liked, t.tag_id, t.description AS tag, u.* " +
                "FROM cuacks AS c INNER JOIN tags AS t ON c.tag_id = t.tag_id INNER JOIN" +
                " users AS u ON c.user_id = u.user_id LEFT JOIN like_cuack AS l ON c.cuack_id" +
                " = l.cuack_id where c.user_id = ? GROUP BY l.cuack_id ORDER BY cuack_creation_date" +
                " desc;")) {
            stmt.setLong(1, sessionId);
            stmt.setLong(2, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cuack c = getCuack(rs);
                    c.setLiked(rs.getInt("liked"));
                    cuacks.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cuacks;
    }

    @Override
    public void add(Cuack cuack) throws SQLException {
        String sql;
        if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
            sql = "UPDATE cuacks SET user_id=?,tag_id=?,content=?,img=?,product_url=?,status=?,title=?,is_edited=? WHERE cuack_id=?";
        } else {
            sql = "INSERT INTO cuacks (user_id,tag_id,content,img,product_url,status,title,is_edited,creation_date) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cuack.getUser().getId());
            stmt.setLong(2, cuack.getTag().getTagID());
            stmt.setString(3, cuack.getContent());
            stmt.setString(4, cuack.getImg());
            stmt.setString(5, cuack.getUrl());
            stmt.setInt(6, cuack.getStatus());
            stmt.setString(7, cuack.getTitle());
            stmt.setInt(8, cuack.isEdited());
            if (cuack.getCuackID() != null && cuack.getCuackID() > 0) {
                stmt.setLong(9, cuack.getCuackID());
            } else {
                stmt.setTimestamp(9, Timestamp.valueOf(cuack.getCreationDate()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM cuacks WHERE cuack_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
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
        c.setStatus(rs.getInt("cuack_status"));
        c.setTitle(rs.getString("title"));
        c.setCreationDate(rs.getTimestamp("cuack_creation_date").toLocalDateTime());
        c.setEdited(rs.getInt("is_edited"));
        c.setLikes(rs.getInt("likes"));

        Tag t = new Tag();
        t.setTagID(rs.getLong("tag_id"));
        t.setDesc(rs.getString("tag"));
        c.setTag(t);

        User u = Util.getUser(rs);
        c.setUser(u);
        return c;
    }

}