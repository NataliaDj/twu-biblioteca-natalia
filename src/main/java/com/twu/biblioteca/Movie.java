package main.java.com.twu.biblioteca;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class Movie {
    private String title;
    private String director;
    private int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
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
}
