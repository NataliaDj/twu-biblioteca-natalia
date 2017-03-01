package com.twu.biblioteca;

/**
 * Created by ndjohari on 1/3/17.
 */
public class User {
    private String librarynum;
    private String password;

    public User(String librarynum, String password) {
        this.librarynum = librarynum;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.librarynum;
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

        result &= librarynum.equals(otherUser.getLibraryNumber());
        result &= password.equals(otherUser.getPassword());

        return result;
    }
}
