package com.bbodenheimer.yucksnyums.model;

public class UserFoodPrep {
    int id;
    int preparation;
    int map;

    public UserFoodPrep(int id, int preparation, int map) {
        this.id = id;
        this.preparation = preparation;
        this.map = map;
    }

    public UserFoodPrep(int preparation, int map) {
        this.preparation = preparation;
        this.map = map;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPreparation() { return preparation; }
    public void setPreparation(int preparation) { this.preparation = preparation; }
    public int getMap() { return map; }
    public void setMap(int map) { this.map = map; }
}
