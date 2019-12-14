package com.bbodenheimer.yucksnyums.model;

public class User {
    int id;
    String username;
    String userComments;

    public User(int id, String username, String userComments) {
        this.id = id;
        this.username = username;
        this.userComments = userComments;
    }

    public User(String username, String userComments) {
        this.username = username;
        this.userComments = userComments;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getUserComments() { return userComments; }
    public void setUserComments(String user_comments) { this.userComments = user_comments; }
}
