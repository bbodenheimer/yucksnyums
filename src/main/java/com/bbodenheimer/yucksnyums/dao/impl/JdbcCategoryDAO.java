package com.bbodenheimer.yucksnyums.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.bbodenheimer.yucksnyums.dao.CategoryDAO;
import com.bbodenheimer.yucksnyums.model.Category;

//TODO: This all needs to be updated to handle ID

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
			throw new RuntimeException(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public List<Category> getAllCategories() {
		String sql = "SELECT * FROM CATEGORY";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Category> allCategory = new ArrayList<Category>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category(
					rs.getInt("id"),
					rs.getString("description"),
					rs.getString("icon")
				);

				allCategory.add(category);
			}
			rs.close();
			ps.close();

			return allCategory;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
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
					rs.getString("description"),
					rs.getString("icon")
				);
			}
			rs.close();
			ps.close();
			
			return category;
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
