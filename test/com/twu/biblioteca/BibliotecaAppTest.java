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

    //Test for selected option List Books a list of books is returned
    @Test
    public void getSelectedMenuOptionResultAddBookReturnsBookListString() {
        assertThat(app.getSelectedMenuOptionResult("List Books"), notNullValue(String.class));
    }

    @Test
    public void isMenuOptionListBookReturnsTrueTest() {
        assertThat(app.isMenuOption("List Book"), is(true));
    }
}
