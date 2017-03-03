package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 27/02/2017.
 */
public abstract class LibraryItem {
    String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.title;
    }
}
