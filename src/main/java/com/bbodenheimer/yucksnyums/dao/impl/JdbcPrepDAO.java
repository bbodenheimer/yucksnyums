package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.PrepDAO;
import com.bbodenheimer.yucksnyums.model.Prep;

public class JdbcPrepDAO implements PrepDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert(Prep prep) {
        String sql = "INSERT INTO PREP" +
                     " (description) VALUES (?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, prep.getDescription());
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

    public Prep findPrepById(int id) {
        String sql = "SELECT * FROM PREP WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Prep prep = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prep = new Prep (
                        rs.getInt("id"),
                        rs.getString("description")
                );
            }
            rs.close();
            ps.close();

            return prep;
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