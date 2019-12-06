package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.CategoryDAO;
import com.bbodenheimer.yucksnyums.model.Category;

public class JdbcCategoryDAO implements CategoryDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Category category) {
		String sql = "INSERT INTO CATEGORY" +
					"(description) VALUES (?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getDescription());
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
	
	public Category findCategoryById(int id) {
		String sql = "SELECT * FROM CATEGORY WHERE ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Category category = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category = new Category(
					rs.getInt("id"),
					rs.getString("description")
				);
			}
			rs.close();
			ps.close();
			
			return category;
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
