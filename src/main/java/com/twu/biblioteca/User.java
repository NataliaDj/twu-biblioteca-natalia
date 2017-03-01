package com.twu.biblioteca;

/**
 * Created by ndjohari on 1/3/17.
 */
public class User {
    private String librarynum;
    private String password;

    public User(String librarynum, String password) {
        setLibraryNumber(librarynum);
        if (this.librarynum == null) {
            throw new IllegalArgumentException();
        }

        this.password = password;
    }

    public String getLibraryNumber() {
        return this.librarynum;
    }

    private boolean setLibraryNumber(String number) {
        String[] splitResult = number.split("-");

        if (splitResult.length != 2) {
            return false;
        }

        if (splitResult[0].length() != 3) {
            return false;
        }

        if (splitResult[1].length() != 4) {
            return false;
        }

        try {
            Integer.parseInt(splitResult[0]);
            Integer.parseInt(splitResult[1]);
        } catch (Exception e) {
            return false;
        }

        this.librarynum = number;
        return true;
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
