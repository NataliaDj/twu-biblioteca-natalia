package com.twu.biblioteca;

/**
 * Created by ndjohari on 1/3/17.
 */
public class User {
    private String librarynum;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String librarynum, String password, String name, String email, String phone) {
        setLibraryNumber(librarynum);
        if (this.librarynum == null) {
            throw new IllegalArgumentException();
        }

        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
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
        result &= name.equals(otherUser.getName());
        result &= email.equals(otherUser.getEmail());
        result &= phone.equals(otherUser.getPhone());

        return result;
    }
}
