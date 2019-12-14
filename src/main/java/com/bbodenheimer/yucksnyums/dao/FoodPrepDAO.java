package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.FoodPrep;

public interface FoodPrepDAO {
    public void insert(FoodPrep foodPrep);
    public FoodPrep findFoodPrepById(int id);
}
