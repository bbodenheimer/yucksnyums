package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.UserFood;

public interface UserFoodDAO {
    public void insert(UserFood userFood);
    public UserFood findUserFoodById(int id);
}
