package com.squawk.webapp.repositories;


import com.squawk.webapp.models.Tag;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagRepositoryImpl implements Repository<Tag> {
    private Connection conn;

    public TagRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Tag> findAll() throws SQLException {
        List<Tag> tags = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tags")) {
            while (rs.next()) {
                Tag t = getTag(rs);

                tags.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }


    @Override
    public Tag findById(Long id) throws SQLException {
        Tag tag = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tags WHERE tag_id= ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    tag = getTag(rs);
                }
            }
        }
        return tag;
    }

    @Override
    public void add(Tag tag) throws SQLException {
        String sql;
        if(tag.getTagID() != null && tag.getTagID() > 0){
            sql = "UPDATE tags SET description=? WHERE tag_id=?";
        }else{
            sql = "INSERT INTO tags (description) VALUES (?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, tag.getDesc());
            if(tag.getTagID() != null && tag.getTagID() > 0) {
                stmt.setLong(2,tag.getTagID());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM tags WHERE tag_id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }
    
    private static Tag getTag(ResultSet rs) throws SQLException {
        Tag t = new Tag();
        t.setTagID(rs.getLong("tag_id"));
        t.setDesc(rs.getString("description"));
        return t;
    }
}
