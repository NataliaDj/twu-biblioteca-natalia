package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Book extends LibraryItem {
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        super(title);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(String title) {
        this(title, "", 0);
    }

    public Book() {
        this("");
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setYearPublished(int year) {
        this.yearPublished = year;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public String getDetails() {
        String result = "";

        result += this.getTitle();
        result += "\nAuthor: " + this.author;
        result += "\nYear Published: " + this.yearPublished;
        result += "\n";

        return result;
    }

    @Override
    public boolean equals(Object otherBook) {
        return otherBook.getClass() == this.getClass() &&
                this.getTitle().equals(((Book)otherBook).getTitle());
    }
}
