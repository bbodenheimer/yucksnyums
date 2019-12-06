package com.bbodenheimer.yucksnyums.model;

public class Preference {
    int id;
    String description;

    public Preference(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Preference(String description) {
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
