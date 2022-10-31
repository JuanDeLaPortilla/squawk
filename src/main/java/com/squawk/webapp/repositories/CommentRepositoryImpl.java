package com.squawk.webapp.repositories;


import com.squawk.webapp.models.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements Repository<Comment> {
    private Connection conn;

    public CommentRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Comment> findAll() throws SQLException {
        List<Comment> comments = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM comments")) {
            while (rs.next()) {
                Comment c = getComment(rs);

                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }


    @Override
    public Comment findById(Long id) throws SQLException {
        Comment comment = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM comments WHERE comment_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    comment = getComment(rs);
                }
            }
        }
        return comment;
    }

    @Override
    public void add(Comment comment) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM comments WHERE comment_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static Comment getComment(ResultSet rs) throws SQLException {
        Comment c = new Comment();
        c.setCommentID(rs.getLong("comment_id"));
        c.setDesc(rs.getString("description"));
        c.setRating(rs.getDouble("rating"));
        c.setStatus(rs.getInt("status"));
        c.setCreationDate(rs.getDate("creation_date"));
        return c;
    }

}
