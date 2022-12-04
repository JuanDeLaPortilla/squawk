package com.squawk.webapp.repositories;

import java.sql.SQLException;

public interface DislikeCuackRepository<T>{
    String add(Long cuackId, Long userId) throws SQLException;
    Integer countDislikesOnCuacks(Long cuackId) throws SQLException;
    Boolean isDislikedByUser(Long cuackId, Long userId) throws SQLException;
    String delete(Long cuackId, Long userId) throws SQLException;
}
