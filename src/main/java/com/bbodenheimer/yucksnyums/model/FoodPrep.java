package com.bbodenheimer.yucksnyums.model;

public class FoodPrep {
    int id;
    int preparation;
    int food;

    public FoodPrep(int id, int preparation, int food) {
        this.id = id;
        this.preparation = preparation;
        this.food = food;
    }

    public FoodPrep(int preparation, int food) {
        this.preparation = preparation;
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreparation() {
        return preparation;
    }

    public void setPreparation(int preparation) {
        this.preparation = preparation;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
/*
    @Override
    public String
*/
}
