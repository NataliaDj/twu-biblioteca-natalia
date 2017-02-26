package main.java.com.twu.biblioteca;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class Movie {
    private String title;
    private String director;
    private int year;
    private int rating;

    public Movie(String title, String director, int year, int rating) {
        if (rating < 1 || rating > 10)
            throw new IllegalArgumentException("Invalid rating value");
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
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
}
