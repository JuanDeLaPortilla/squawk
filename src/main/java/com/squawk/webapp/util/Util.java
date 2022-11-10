package com.squawk.webapp.util;

import com.squawk.webapp.models.User;
import jakarta.servlet.http.Part;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
    public static String getFileName(Part part){
        String contentDisposition = part.getHeader("content-disposition");

        if (!contentDisposition.contains("filename=")){
            return null;
        }

        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex,endIndex);
    }

    public static User getUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getLong("user_id"));
        u.setName(rs.getString("nickname"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        u.setImg(rs.getString("profile_picture"));
        u.setType(rs.getInt("user_type"));
        u.setStatus(rs.getInt("status"));
        u.setBirthday(rs.getDate("birthday").toLocalDate());
        u.setCreationDate(rs.getDate("creation_date").toLocalDate());
        return u;
    }
}
