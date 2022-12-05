package com.squawk.webapp.repositories;

import com.squawk.webapp.models.User;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.countByMonth;
import com.squawk.webapp.models.Tag;
import com.squawk.webapp.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class countByMonthRepositoryImpl implements countByMonthRepository<countByMonth> {
    private Connection conn;

    public countByMonthRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    
    @Override
    public List<countByMonth> findCantCuacks() throws SQLException {
        List<countByMonth> cantc = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select monthname(creation_date) as mes, "+
                     "ifnull(COUNT(*),0) as numero_cuacks_creados "+
                     "FROM cuacks WHERE year(creation_date)=year(CURRENT_DATE)"+
                     " GROUP BY month(creation_date) desc limit 5")) {
            while (rs.next()) {
                countByMonth cc = getCountCuacks(rs);
                cantc.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cantc;
    }

    @Override
    public List<countByMonth> findCantUsers() throws SQLException {
        List<countByMonth> cantu = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select monthname(creation_date) as mes, "+
                     "ifnull(COUNT(*),0) as numero_users_creados "+
                     "FROM users WHERE year(creation_date)=year(CURRENT_DATE)"+
                     " GROUP BY month(creation_date) desc limit 5")) {
            while (rs.next()) {
                countByMonth cu = getCountUsers(rs);
                cantu.add(cu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cantu;
    }
    
    private static countByMonth getCountCuacks(ResultSet rs) throws SQLException {
        countByMonth cc = new countByMonth();

        cc.setMes(rs.getString("mes"));
        cc.setCant(rs.getInt("numero_cuacks_creados"));
        return cc;
    }
    
    private static countByMonth getCountUsers(ResultSet rs) throws SQLException {
        countByMonth cu = new countByMonth();

        cu.setMes(rs.getString("mes"));
        cu.setCant(rs.getInt("numero_users_creados"));
        return cu;
    }

}