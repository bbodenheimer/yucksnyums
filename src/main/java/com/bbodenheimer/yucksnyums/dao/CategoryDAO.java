package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Category;

public interface CategoryDAO {
	public void insert(Category category);
	public Category findCategoryById(int id);
}
