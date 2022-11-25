package com.squawk.webapp.repositories;

import java.sql.SQLException;

public interface LikeCuackRepository <T>{
    String add(Long cuackId, Long userId) throws SQLException;
    Integer countLikesOnCuacks(Long cuackId) throws SQLException;
    Boolean isLikedByUser(Long cuackId, Long userId) throws SQLException;
    String delete(Long cuackId, Long userId) throws SQLException;
}
