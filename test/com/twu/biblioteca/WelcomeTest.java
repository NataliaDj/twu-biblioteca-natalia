package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
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

    @Test
    public void getWelcomeMessageReturnsNewLineAtEnd() {
        BibliotecaApp app = new BibliotecaApp();
        assertThat(app.getWelcomeMessage(), endsWith("\n"));
    }


}
