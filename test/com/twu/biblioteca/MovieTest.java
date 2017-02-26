package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 26/02/2017.
 */
public class MovieTest {
    @Test
    public void getTitleReturnTitle() {
        String title = "Sherlock Holmes";
        Movie movie = new Movie(title);
        assertThat(movie.getTitle(), is(title));
    }
}
