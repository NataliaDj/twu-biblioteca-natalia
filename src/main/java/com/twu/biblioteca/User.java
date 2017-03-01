package com.twu.biblioteca;

/**
 * Created by ndjohari on 1/3/17.
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User otherUser = (User) obj;

        boolean result = true;

        result &= username.equals(otherUser.getUsername());
        result &= password.equals(otherUser.getPassword());

        return result;
    }
}
