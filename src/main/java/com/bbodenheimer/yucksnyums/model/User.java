package com.bbodenheimer.yucksnyums.model;

public class User {
    int id;
    String username;
    String user_comments;

    public User(int id, String username, String user_comments) {
        this.id = id;
        this.username = username;
        this.user_comments = user_comments;
    }

    public User(String username, String user_comments) {
        this.username = username;
        this.user_comments = user_comments;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getUser_comments() { return user_comments; }
    public void setUser_comments(String user_comments) { this.user_comments = user_comments; }
}
