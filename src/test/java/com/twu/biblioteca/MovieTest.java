package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void constructMovieWith0RatingReturnsIllegalArgumentExceptionTest() {
        try {
            movie = new Movie(title, director, year, 0);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void constructMovieWith11RatingReturnsIllegalArgumentExceptionTest() {
        try {
            movie = new Movie(title, director, year, 11);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getDetailsReturnsStringContainsAllDetailsTest() {
        String details = movie.getDetails();
        assertThat(details, containsString(title));
        assertThat(details, containsString(director));
        assertThat(details, containsString(String.valueOf(year)));
        assertThat(details, containsString(String.valueOf(rating)));


    }
}
