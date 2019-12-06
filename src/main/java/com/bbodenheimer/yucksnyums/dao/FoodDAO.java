package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Food;

public interface FoodDAO {
    public void insert(Food food);
    public Food findFoodById(int id);
}
