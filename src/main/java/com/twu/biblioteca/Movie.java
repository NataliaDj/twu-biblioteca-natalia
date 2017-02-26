package main.java.com.twu.biblioteca;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class Movie {
    private String title;
    private String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }
}
