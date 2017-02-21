package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Book {
    private String title;
    private String author;
    private int year;

    public Book() {
        this.title = "";
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public boolean equals(Object otherBook) {
        return otherBook.getClass() == this.getClass() &&
                this.title.equals(((Book)otherBook).getTitle());
    }

    public String toString() {
        return "Book " + this.title;
    }
}
