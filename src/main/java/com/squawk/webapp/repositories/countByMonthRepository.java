package com.squawk.webapp.repositories;

import java.sql.SQLException;
import java.util.List;

public interface countByMonthRepository<T>{
    List<T> findCantCuacks() throws SQLException;
    List<T> findCantUsers() throws SQLException;
}
