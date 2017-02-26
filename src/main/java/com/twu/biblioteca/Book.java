package main.java.com.twu.biblioteca;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(String title) {
        this(title, "", 0);
    }

    public Book() {
        this("");
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

    public void setYearPublished(int year) {
        this.yearPublished = year;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public String getDetails() {
        String result = "";

        result += this.title;
        result += "\nAuthor: " + this.author;
        result += "\nYear Published: " + this.yearPublished;
        result += "\n";

        return result;
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
