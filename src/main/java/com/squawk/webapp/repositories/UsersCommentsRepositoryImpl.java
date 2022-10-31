package com.squawk.webapp.repositories;


import com.squawk.webapp.models.UsersComments;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersCommentsRepositoryImpl implements Repository<UsersComments> {
    private Connection conn;

    public UsersCommentsRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<UsersComments> findAll() throws SQLException {
        List<UsersComments> uc = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_comments")) {
            while (rs.next()) {
                UsersComments u = getUsersComments(rs);

                uc.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uc;
    }


    @Override
    public UsersComments findById(Long id) throws SQLException {
        UsersComments uc = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users_comments WHERE user_id= ? AND comment_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    uc = getUsersComments(rs);
                }
            }
        }
        return uc;
    }

    @Override
    public void add(UsersComments uc) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users_comments WHERE user_id=? AND comment_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    private static UsersComments getUsersComments(ResultSet rs) throws SQLException {
        UsersComments uc = new UsersComments();
        uc.setUserID(rs.getLong("user_id"));
        uc.setCommentID(rs.getLong("comment_id"));
        return uc;
    }
}
