package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.PreferenceDAO;
import com.bbodenheimer.yucksnyums.model.Preference;

public class JdbcPreferenceDAO implements PreferenceDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    public void insert (Preference preference) {
        String sql = "INSERT INTO PREFERENCE" +
                     "(description) VALUES (?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, preference.getDescription());
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

    public Preference findPreferenceById(int id) {
        String sql = "SELECT * FROM PREFERENCE WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Preference preference = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                preference = new Preference(
                             rs.getInt("id"),
                             rs.getString("description")
                );
            }
            rs.close();
            ps.close();

            return preference;
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
