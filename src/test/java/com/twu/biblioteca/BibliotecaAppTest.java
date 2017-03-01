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
        defaultUser = new User("004-1027", "pass", "John Smith", "j.smith@mail.com", "8903921");
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
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Book Hamlet"), is("Thank you! Enjoy the book"));
    }

    @Test
    public void getMenuOptionResultCheckoutBookNoBookSpecifiedReturnsInvalidMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Book"), is("That book is not available."));
    }

    @Test
    public void getMenuOptionResultCheckoutBookUnsuccessfullyReturnsUnavailableMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Book Tarzan"), is("That book is not available."));
    }

    @Test
    public void getMenuOptionResultReturnBookSuccessfullyReturnsThankYouMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        app.getMenuOptionResult("Checkout Book Hamlet");
        assertThat(app.getMenuOptionResult("Return Book Hamlet"), is("Thank you for returning the book."));
    }

    @Test
    public void getMenuOptionResultReturnBookNoBookSpecifiedReturnsInvalidBookMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Return Book"), is("That is not a valid book to return."));
    }

    @Test
    public void getMenuOptionResultReturnBookUnlistedBookReturnsInvalidBookMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Return Book Tarzan"), is("That is not a valid book to return."));
    }

    @Test
    public void getMenuOptionResultReturnBookNonCheckedoutBookReturnsInvalidBookMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
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
    public void viewMenuOptionsContainBasicMenuItems() {
        String viewOptions = app.viewMenuOptions();
        for (String option: Menu.getBasicMenuOptionsList()) {
            assertThat(viewOptions, containsString(option));
        }
    }

    @Test
    public void viewMenuOptionsAfterLoginContainFullMenuItems() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
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
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Movie Jaws"), is("Thank you! Enjoy the movie"));
    }

    @Test
    public void getMenuOptionResultCheckoutMovieNoMovieSpecifiedReturnsInvalidMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Movie"), is("That movie is not available."));
    }

    @Test
    public void getMenuOptionResultCheckoutMovieUnsuccessfullyReturnsUnavailableMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Checkout Movie Tarzan"), is("That movie is not available."));
    }

    @Test
    public void getMenuOptionResultReturnMovieSuccessfullyReturnsThankYouMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        app.getMenuOptionResult("Checkout Movie Jaws");
        assertThat(app.getMenuOptionResult("Return Movie Jaws"), is("Thank you for returning the movie."));
    }

    @Test
    public void getMenuOptionResultReturnMovieNoMovieSpecifiedReturnsInvalidMovieMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Return Movie"), is("That is not a valid movie to return."));
    }

    @Test
    public void getMenuOptionResultReturnMovieUnlistedMovieReturnsInvalidBookMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        assertThat(app.getMenuOptionResult("Return Movie Tarzan"), is("That is not a valid movie to return."));
    }

    @Test
    public void getMenuOptionResultReturnMovieNonCheckedoutMovieReturnsInvalidBookMessage() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
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
        assertThat(message, is("Welcome " + defaultUser.getName()));
    }

    @Test
    public void isLoggedInReturnsFalseAfterLogout() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        app.logout();
        assertThat(app.isLoggedIn(), is(false));
    }

    @Test
    public void ListCheckedOutItemsContainsCheckedOutItemDetails() {
        app.login(defaultUser.getLibraryNumber(), defaultUser.getPassword());
        app.getMenuOptionResult("Checkout Book Hamlet");
        app.getMenuOptionResult("Checkout Movie Jaws");

        String result = app.listCheckedOut();
        assertThat(result, containsString(defaultUser.getLibraryNumber()));
        assertThat(result, containsString("Hamlet"));
        assertThat(result, containsString("Jaws"));
    }
}
