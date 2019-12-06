package com.bbodenheimer.yucksnyums.model;

public class UserFood {
    int id;
    int food;
    int user;
    int preference;
    String comment;

    public UserFood(int id, int food, int user, int preference, String comment) {
        this.id = id;
        this.food = food;
        this.user = user;
        this.preference = preference;
        this.comment = comment;
    }

    public UserFood(int food, int user, int preference, String comment) {
        this.food = food;
        this.user = user;
        this.preference = preference;
        this.comment = comment;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id;}
    public int getFood() { return food; }
    public void setFood(int food) { this.food = food;}
    public int getUser() { return user; }
    public void setUser(int user) { this.user = user; }
    public int getPreference() { return preference; }
    public void setPreference(int preference) { this.preference = preference; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
