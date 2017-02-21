package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class WelcomeTest {
    /**
     * Welcome Message
     *
     * As a customer,
     * I would like to see a welcome message when I start the application,
     * so that
     * I feel welcome and know that Biblioteca is available.
     */

    BibliotecaApp app;

    @Before
    public void setup() {
        app = new BibliotecaApp();
    }

    @Test
    public void getWelcomeMessageReturnsWelcomeMessageString() {
        assertThat(app.getWelcomeMessage(), containsString("Welcome to Biblioteca"));
    }

    @Test
    public void getWelcomeMessageReturnsNewLineAtEnd() {
        assertThat(app.getWelcomeMessage(), endsWith("\n"));
    }


}
