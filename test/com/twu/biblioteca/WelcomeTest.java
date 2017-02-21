package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class WelcomeTest {

    @Test
    public void getWelcomeMessageReturnsWelcomeMessageString() {
        BibliotecaApp app = new BibliotecaApp();
        assertThat(app.getWelcomeMessage(), containsString("Welcome to Biblioteca"));
    }
}
