package com.bbodenheimer.yucksnyums.model;

public class FoodPrep {
    int id;
    int Preparation;
    int food;

    public FoodPrep(int id, int Preparation, int food) {
        this.id = id;
        this.Preparation = Preparation;
        this.food = food;
    }

    public FoodPrep(int Preparation, int food) {
        this.Preparation = Preparation;
        this.food = food;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPreparation() { return Preparation; }
    public void setPreparation(int Preparation) { this.Preparation = Preparation; }
    public int getFood() { return food; }
    public void setFood(int food) { this.food = food; }
/*
    @Override
    public String
*/
}
