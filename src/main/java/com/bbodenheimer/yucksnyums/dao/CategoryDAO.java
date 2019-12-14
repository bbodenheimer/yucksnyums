package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Category;

import java.util.List;

public interface CategoryDAO {
	public void insert(Category category);
	public Category findCategoryById(int id);
	public List<Category> getAllCategories();
}
