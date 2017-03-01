package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class BibliotecaAppTest {

    BibliotecaApp app;
    User defaultUser;

    @Before
    public void setup() {
        defaultUser = new User("004-1027", "pass");
        app = BibliotecaApp.defaultBibliotecaApp();
    }

    @Test
    public void getWelcomeMessageContainsWelcomeMessageString() {
        assertThat(app.getWelcomeMessage(), containsString("Welcome to Biblioteca"));
    }

    @Test
    public void getMenuOptionResultListBooksReturnsStringTest() {
        String title = "Emma";
        String author = "Jane Austen";
        int yearPublished = 1815;
        ArrayList<Book> books = new ArrayList<Book>(
                Arrays.asList(
                        new Book(title, author, yearPublished)
                )
        );
        Library lib = new Library(books, new ArrayList<Movie>(), new ArrayList<User>());
        app = new BibliotecaApp(lib);

        String result = app.getMenuOptionResult("List Books");
        assertThat(result, containsString(title));
        assertThat(result, containsString(author));
        assertThat(result, containsString(String.valueOf(yearPublished)));
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
    public void getMenuOptionResultCheckoutBookSuccessfullyReturnsThankYouMessage() {
        assertThat(app.getMenuOptionResult("Checkout Book Hamlet"), is("Thank you! Enjoy the book"));
    }

    @Test
    public void getMenuOptionResultCheckoutBookNoBookSpecifiedReturnsInvalidMessage() {
        assertThat(app.getMenuOptionResult("Checkout Book"), is("That book is not available."));
    }

    @Test
    public void getMenuOptionResultCheckoutBookUnsuccessfullyReturnsUnavailableMessage() {
        assertThat(app.getMenuOptionResult("Checkout Book Tarzan"), is("That book is not available."));
    }

    @Test
    public void getMenuOptionResultReturnBookSuccessfullyReturnsThankYouMessage() {
        app.getMenuOptionResult("Checkout Book Hamlet");
        assertThat(app.getMenuOptionResult("Return Book Hamlet"), is("Thank you for returning the book."));
    }

    @Test
    public void getMenuOptionResultReturnBookNoBookSpecifiedReturnsInvalidBookMessage() {
        assertThat(app.getMenuOptionResult("Return Book"), is("That is not a valid book to return."));
    }

    @Test
    public void getMenuOptionResultReturnBookUnlistedBookReturnsInvalidBookMessage() {
        assertThat(app.getMenuOptionResult("Return Book Tarzan"), is("That is not a valid book to return."));
    }

    @Test
    public void getMenuOptionResultReturnBookNonCheckedoutBookReturnsInvalidBookMessage() {
        assertThat(app.getMenuOptionResult("Return Book Hamlet"), is("That is not a valid book to return."));
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

    @Test
    public void viewMenuOptionsContainMenuItems() {
        String viewOptions = app.viewMenuOptions();
        for (String option: Menu.getFullMenuOptionsList()) {
            assertThat(viewOptions, containsString(option));
        }

    }

    @Test
    public void getMenuOptionResultListMovieReturnsMovieDetailsStringTest() {
        String title = "Tangled";
        String director = "Nathan Greno";
        int yearReleased = 2010;
        int rating = 8;
        ArrayList<Movie> movies = new ArrayList<Movie>(
                Arrays.asList(
                        new Movie(title, director, yearReleased, rating)
                )
        );
        Library lib = new Library(new ArrayList<Book>(), movies, new ArrayList<User>());
        app = new BibliotecaApp(lib);

        String result = app.getMenuOptionResult("List Movies");
        assertThat(result, containsString(title));
        assertThat(result, containsString(director));
        assertThat(result, containsString(String.valueOf(yearReleased)));
        assertThat(result, containsString(String.valueOf(rating)));
    }

    @Test
    public void getMenuOptionResultCheckoutMovieSuccessfullyReturnsThankYouMessage() {
        assertThat(app.getMenuOptionResult("Checkout Movie Jaws"), is("Thank you! Enjoy the movie"));
    }

    @Test
    public void getMenuOptionResultCheckoutMovieNoMovieSpecifiedReturnsInvalidMessage() {
        assertThat(app.getMenuOptionResult("Checkout Movie"), is("That movie is not available."));
    }

    @Test
    public void getMenuOptionResultCheckoutMovieUnsuccessfullyReturnsUnavailableMessage() {
        assertThat(app.getMenuOptionResult("Checkout Movie Tarzan"), is("That movie is not available."));
    }

    @Test
    public void getMenuOptionResultReturnMovieSuccessfullyReturnsThankYouMessage() {
        app.getMenuOptionResult("Checkout Movie Jaws");
        assertThat(app.getMenuOptionResult("Return Movie Jaws"), is("Thank you for returning the movie."));
    }

    @Test
    public void getMenuOptionResultReturnMovieNoMovieSpecifiedReturnsInvalidMovieMessage() {
        assertThat(app.getMenuOptionResult("Return Movie"), is("That is not a valid movie to return."));
    }

    @Test
    public void getMenuOptionResultReturnMovieUnlistedMovieReturnsInvalidBookMessage() {
        assertThat(app.getMenuOptionResult("Return Movie Tarzan"), is("That is not a valid movie to return."));
    }

    @Test
    public void getMenuOptionResultReturnMovieNonCheckedoutMovieReturnsInvalidBookMessage() {
        assertThat(app.getMenuOptionResult("Return Movie Jaws"), is("That is not a valid movie to return."));
    }

    @Test
    public void isLoggedInReturnFalseInitially() {
        assertThat(app.isLoggedIn(), is(false));
    }

    @Test
    public void isLoggedInReturnsTrueAfterSuccessfulLogin() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.isLoggedIn(), is(true));
    }

    @Test
    public void isLoggedInReturnFailAfterUnsuccessfulLogin() {
        app.login("123-4567", "nonexistantuser");
        assertThat(app.isLoggedIn(), is(false));
    }


    @Test
    public void loginSuccessfullyReturnsWelcomeMessage() {
        String message = app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(message, is("Welcome "));
    }
}
