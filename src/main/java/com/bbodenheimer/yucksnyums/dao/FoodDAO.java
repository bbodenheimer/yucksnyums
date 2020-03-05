package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Food;

import java.sql.SQLException;

public interface FoodDAO {
    public void insert(Food food) throws SQLException;
    public Food findFoodById(int id);
}
