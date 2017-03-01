package com.twu.biblioteca;

/**
 * Created by ndjohari on 1/3/17.
 */
public class User {
    private String username;

    public User(String username, String password) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
