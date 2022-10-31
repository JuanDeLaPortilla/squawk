package com.squawk.webapp.repositories;


import com.squawk.webapp.models.LikeComment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeCommentRepositoryImpl implements Repository<LikeComment> {
    private Connection conn;

    public LikeCommentRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<LikeComment> findAll() throws SQLException {
        List<LikeComment> lc = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM like_comment")) {
            while (rs.next()) {
                LikeComment l = getLikeComment(rs);

                lc.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lc;
    }


    @Override
    public LikeComment findById(Long id) throws SQLException {
        LikeComment lc = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM like_comment WHERE like_comment_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    lc = getLikeComment(rs);
                }
            }
        }
        return lc;
    }

    @Override
    public void add(LikeComment lc) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM like_comment WHERE like_comment_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static LikeComment getLikeComment(ResultSet rs) throws SQLException {
        LikeComment t = new LikeComment();
        t.setLikeCommentID(rs.getLong("like_comment_id"));
        t.setUserID(rs.getLong("user_id"));
        t.setCommentID(rs.getLong("comment_id"));
        return t;
    }
}