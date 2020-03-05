package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.UserFoodDAO;
import com.bbodenheimer.yucksnyums.model.UserFood;

public class JdbcUserFoodDAO implements UserFoodDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {this.dataSource = dataSource; }

    public void insert(UserFood userFood) {
        String sql = "INSERT INTO USERFOOD" +
                     " (food, user, preference, comment) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userFood.getFood());
            ps.setInt(2, userFood.getUser());
            ps.setInt(3, userFood.getPreference());
            ps.setString(4, userFood.getComment());
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

    public UserFood findUserFoodById(int id) {
        String sql = "SELECT * FROM USERFOOD WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            UserFood userFood = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userFood = new UserFood (
                        rs.getInt("id"),
                        rs.getInt("food"),
                        rs.getInt("user"),
                        rs.getInt("preference"),
                        rs.getString("comment")
                );
            }
            rs.close();
            ps.close();

            return userFood;
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