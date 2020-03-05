package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.FoodDAO;
import com.bbodenheimer.yucksnyums.model.Food;

public class JdbcFoodDAO implements FoodDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert(Food food) throws SQLException {
        String sql = "INSERT INTO FOOD" +
                     " (description, category) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, food.getDescription());
            ps.setInt(2, food.getCategory());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage()) ;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Food findFoodById(int id) {
        String sql = "SELECT * FROM FOOD WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Food food = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                food = new Food (
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("category")
                );
            }
            rs.close();
            ps.close();

            return food;
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
