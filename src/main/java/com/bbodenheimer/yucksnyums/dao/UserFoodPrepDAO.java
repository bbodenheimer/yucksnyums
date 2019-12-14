package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.UserFoodPrep;

public interface UserFoodPrepDAO {
    public void insert(UserFoodPrep userFoodPrep);
    public UserFoodPrep findUserFoodPrepById(int id);
}
