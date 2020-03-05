package com.bbodenheimer.yucksnyums.model;

public class Food {
    int id;
    String description;
    int category;

    public Food() {
        super();
    }

    public Food(int id, String description, int category) {
        this.id = id;
        this.description = description;
        this.category = category;
    }

    public Food(String description, int category) {
        this.description = description;
        this.category = category;
    }

    public int getId() { return id; }
    public void setId(int id) {this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getCategory() { return category; }
    public void setCategory(int category) { this.category = category; }

    @Override
    public String toString() {
        return "Food [id =" + id + ", description" + description + ", category" + category + "]";
    }
}