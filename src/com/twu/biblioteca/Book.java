package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Book {
    private String title;

    public Book() {
        this.title = "";
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object otherBook) {
        return true;
    }

    public String toString() {
        return "Book " + this.title;
    }
}
