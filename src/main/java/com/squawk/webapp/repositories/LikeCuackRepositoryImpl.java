package com.squawk.webapp.repositories;

import com.squawk.webapp.models.LikeCuack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeCuackRepositoryImpl implements LikeCuackRepository<LikeCuack> {
    private Connection conn;

    public LikeCuackRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String add(Long cuackId, Long userId) throws SQLException {
        String msg = "";
        boolean f = false;
        try {
            String sql = "insert into like_cuack(cuack_id,user_id) values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, cuackId);
            stmt.setLong(2, userId);
            stmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg += f;
        if (f){
            msg+="&1";
        }
        return msg;
    }

    @Override
    public Integer countLikesOnCuacks(Long cuackId) throws SQLException {
        int count = 0;

        String sql = "select count(*) from like_cuack where cuack_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, cuackId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Boolean isLikedByUser(Long cuackId, Long userId) throws SQLException {
        boolean f = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from like_cuack where cuack_id=? and user_id=?");
            stmt.setLong(1, cuackId);
            stmt.setLong(2, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public String delete(Long cuackId, Long userId) throws SQLException {
        String msg="";
        boolean f = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from like_cuack where cuack_id=? and user_id=?");
            stmt.setLong(1, cuackId);
            stmt.setLong(2, userId);
            stmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg += f;
        if (f){
            msg+="&0";
        }
        return msg;
    }
}
