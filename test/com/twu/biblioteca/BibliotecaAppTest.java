package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
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
    public void getMenuOptionsContainsListBooksString() {
        assertThat(app.getMenuOptions(), hasItem("List Books"));
    }

    @Test
    public void isMenuOptionListBookReturnsTrueTest() {
        assertThat(app.isMenuOption("List Books"), is(true));
    }

    @Test
    public void isMenuOptionEmptyStringReturnsFalseTest() {
        assertThat(app.isMenuOption(""), is(false));
    }

    @Test
    public void isMenuOptionQuitReturnsTrueTest() {
        assertThat(app.isMenuOption("Quit"), is(true));
    }

    @Test
    public void getMenuOptionResultListBooksReturnsString() {
        assertThat(app.getMenuOptionResult("List Books"), notNullValue(String.class));
    }

    @Test
    public void getMenuOptionResultInvalidOptionReturnsInvalidMessageString() {
        assertThat(app.getMenuOptionResult("Invalid Option"), is("Select a valid option!"));
    }

    @Test
    public void getMenuOptionResultQuitReturnsEmptyString() {
        assertThat(app.getMenuOptionResult("Quit"), is(""));
    }

    @Test
    public void isRunningReturnTrue() {
        assertThat(app.isRunning(), is (true));
    }
}
