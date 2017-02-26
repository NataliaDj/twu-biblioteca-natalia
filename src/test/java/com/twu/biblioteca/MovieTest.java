package test.java.com.twu.biblioteca;

import main.java.com.twu.biblioteca.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class MovieTest {
    String title;
    String director;
    int year;
    int rating;
    Movie movie;

    @Before
    public void setup() {
        title = "Sherlock Holmes: A Game of Shadows";
        director = "Guy Ritchie";
        year = 2011;
        rating = 7;
        movie = new Movie(title, director, year, rating);
    }

    @Test
    public void getTitleReturnTitleStringTest() {
        assertThat(movie.getTitle(), is(title));
    }

    @Test
    public void getDirectorReturnsDirectorStringTest() {
        assertThat(movie.getDirector(), is(director));

    }

    @Test
    public void getYearReleasedReturnYearIntTest() {
        assertThat(movie.getYearReleased(), is (year));
    }

    @Test
    public void getRatingReturnsRatingIntTest() {
        assertThat(movie.getRating(), is(rating));
    }
}
