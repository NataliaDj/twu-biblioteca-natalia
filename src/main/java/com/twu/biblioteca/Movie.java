package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class Movie extends LibraryItem {
    private String director;
    private int year;
    private int rating;

    public Movie(String title, String director, int year, int rating) {
        super(title);
        if (rating < 1 || rating > 10)
            throw new IllegalArgumentException("Invalid rating value");
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getDirector() {
        return this.director;
    }

    public int getYearReleased() {
        return this.year;
    }

    public int getRating() {
        return this.rating;
    }

    public String getDetails() {
        String result = "";

        result += this.getTitle() + "\n";
        result += "Director: " + this.director + "\n";
        result += "Year Released: " + this.year + "\n";
        result += "Rating: " + this.rating + "\n";

        return result;
    }

    public boolean equals(Movie movie) {
        boolean result = true;

        result &= this.getTitle().equals(movie.getTitle());
        result &= director.equals(movie.getDirector());
        result &= year == movie.getYearReleased();
        result &= rating == movie.getRating();

        return result;
    }
}
