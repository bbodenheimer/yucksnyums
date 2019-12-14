package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.FoodPrepDAO;
import com.bbodenheimer.yucksnyums.model.FoodPrep;

public class JdbcFoodPrepDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert(FoodPrep foodPrep) {
        String sql = "INSERT INTO FOODPREP" +
                     " (prep, food) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, foodPrep.getPreparation());
            ps.setInt(2, foodPrep.getFood());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public FoodPrep findFoodPrepById(int id) {
        String sql = "SELECT * FROM FOODPREP WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            FoodPrep foodPrep = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                foodPrep = new FoodPrep (
                        rs.getInt("id"),
                        rs.getInt("food")
                );
            }
            rs.close();
            ps.close();

            return foodPrep;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}



























