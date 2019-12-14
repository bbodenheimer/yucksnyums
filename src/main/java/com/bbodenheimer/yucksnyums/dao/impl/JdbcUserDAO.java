package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.UserDAO;
import com.bbodenheimer.yucksnyums.model.User;

public class JdbcUserDAO implements UserDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert(User user) {
        String sql = "INSERT INTO USER" +
                     " (username, user_comments) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getUserComments());
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

    public User findUserById(int id) {
        String sql = "SELECT * FROM USER WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User (
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("user_comments")
                );
            }
            rs.close();
            ps.close();

            return user;
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