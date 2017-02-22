package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class BibliotecaAppTest {

    BibliotecaApp app;

    @Before
    public void setup() {
        app = new BibliotecaApp();
    }

    @Test
    public void getWelcomeMessageContainsWelcomeMessageString() {
        assertThat(app.getWelcomeMessage(), containsString("Welcome to Biblioteca"));
    }

    @Test
    public void getWelcomeMessageReturnsNewLineAtEnd() {
        assertThat(app.getWelcomeMessage(), endsWith("\n"));
    }

    @Test
    public void getMenuOptionResultListBooksReturnsStringTest() {
        assertThat(app.getMenuOptionResult("List Books"), notNullValue(String.class));
    }

    @Test
    public void getMenuOptionResultInvalidOptionReturnsInvalidMessageStringTest() {
        assertThat(app.getMenuOptionResult("Invalid Option"), is("Select a valid option!"));
    }

    @Test
    public void getMenuOptionResultQuitReturnsEmptyStringTest() {
        assertThat(app.getMenuOptionResult("Quit"), is(""));
    }

    @Test
    public void isRunningReturnTrueTest() {
        assertThat(app.isRunning(), is (true));
    }

    @Test
    public void isRunningAfterGetMethodOptionResultQuitIsFalseTest() {
        assertThat(app.isRunning(), is (true));
        app.getMenuOptionResult("Quit");
        assertThat(app.isRunning(), is (false));
    }
}
