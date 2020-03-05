package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.UserFoodPrepDAO;
import com.bbodenheimer.yucksnyums.model.UserFoodPrep;

public class JdbcUserFoodPrepDAO implements UserFoodPrepDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert(UserFoodPrep userFoodPrep) {
        String sql = "INSERT INTO USERFOODPREP" +
                     " (preparation, map) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userFoodPrep.getPreparation());
            ps.setInt(2, userFoodPrep.getMap());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public UserFoodPrep findUserFoodPrepById(int id) {
        String sql = "SELECT * FROM USERFOODPREP WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            UserFoodPrep userFoodPrep = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userFoodPrep = new UserFoodPrep (
                        rs.getInt("id"),
                        rs.getInt("preparation"),
                        rs.getInt("map")
                );
            }
            rs.close();
            ps.close();

            return userFoodPrep;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}