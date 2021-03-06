package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class LibraryTest {
    Movie movie;
    Library lib;
    String defaultLibraryNum;

    @Before
    public void setup() {
        this.lib = Library.defaultLibrary();

        String title = "Tangled";
        String director = "Nathan Greno";
        int yearReleased = 2010;
        int rating = 8;
        this.movie = new Movie(title, director, yearReleased, rating);

        User u = lib.getUsersList().get(0);
        defaultLibraryNum = u.getLibraryNumber();
    }

    @Test
    public void getBookListReturns0ForEmptyLibraryTest() {
        lib = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), new ArrayList<User>());
        assertThat(lib.getBookList().size(), is(0));
    }

    @Test
    public void getDefaultBookListReturnNotEmptyList() {
        assertThat(lib.getBookList().size(), not(is(0)));
    }

    @Test
    public void addBookAddsTheBookToBookListTest() {
        int initialSize = lib.getBookList().size();
        lib.addBook(new Book());
        assertThat(lib.getBookList().size(), is(initialSize + 1));
    }

    //test library contains book that was added
    @Test
    public void addBookAddsSameBookToBookListTest() {
        Book book = new Book("Call of The Wild");
        lib.addBook(book);
        assertThat(lib.getBookList(), hasItem(book));
    }

    //test add book does not change other books in library
    @Test
    public void addBookDoesNotChangeOtherBooksInListTest() {
        Book firstBook = new Book("Hamlet");
        Book secondBook = new Book("Lion King");
        lib.addBook(firstBook);
        lib.addBook(secondBook);
        assertThat(lib.getBookList(), hasItems(firstBook, secondBook));
    }

    @Test
    public void checkoutBookRemovesBookFromList() {

        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        lib.checkoutBook(title, defaultLibraryNum);
        assertThat(lib.getBookList(), not(hasItem(book)));
    }

    @Test
    public void checkoutBookSuccessfullyReturnsTrue() {
        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        assertThat(lib.checkoutBook(title, defaultLibraryNum), is(true));
    }


    @Test
    public void checkoutBookUnsuccessfullyReturnsFalseTest() {
        String title = "Three Blind Mice";
        assertThat(lib.checkoutBook(title, defaultLibraryNum), is(false));
    }

    @Test
    public void returnBookInsertsBookToBookListTest() {
        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        lib.checkoutBook(title, defaultLibraryNum);
        lib.returnBook(title, defaultLibraryNum);
        assertThat(lib.getBookList(), hasItem(book));
    }

    @Test
    public void returnBookSuccessfullyReturnsTrue() {
        String title = "Three Blind Mice";
        lib.addBook(new Book(title));
        lib.checkoutBook(title, defaultLibraryNum);
        assertThat(lib.returnBook(title, defaultLibraryNum), is(true));
    }

    @Test
    public void returnBookUnsuccessfullyReturnFalse() {
        assertThat(lib.returnBook("Three Blind Mice", defaultLibraryNum), is(false));
    }

    @Test
    public void getMoviesListReturns0ForEmptyLibraryTest() {
        lib = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), new ArrayList<User>());
        assertThat(lib.getMoviesList().size(), is(0));
    }

    @Test
    public void getDefaultMoviesListReturnNotEmptyList() {
        assertThat(lib.getMoviesList().size(), not(is(0)));
    }

    @Test
    public void checkoutMovieRemoveMovieFromMovieListTest() {
        lib.addMovie(movie);
        lib.checkoutMovie(movie.getTitle(), defaultLibraryNum);
        assertThat(lib.getMoviesList(), not(hasItem(movie)));

    }

    @Test
    public void checkoutMovieSuccessfullyReturnsTrue() {
        lib.addMovie(movie);
        assertThat(lib.checkoutMovie(movie.getTitle(), defaultLibraryNum), is(true));
    }


    @Test
    public void checkoutMovieUnsuccessfullyReturnsFalseTest() {
        assertThat(lib.checkoutMovie(movie.getTitle(), defaultLibraryNum), is(false));
    }

    @Test
    public void returnMovieInsertsMovieToMovieListTest() {
        lib.addMovie(movie);
        lib.checkoutMovie(movie.getTitle(), defaultLibraryNum);
        lib.returnMovie(movie.getTitle(), defaultLibraryNum);
        assertThat(lib.getMoviesList(), hasItem(movie));
    }

    @Test
    public void returnMovieSuccessfullyReturnsTrue() {
        lib.addMovie(movie);
        lib.checkoutMovie(movie.getTitle(), defaultLibraryNum);
        assertThat(lib.returnMovie(movie.getTitle(), defaultLibraryNum), is(true));
    }

    @Test
    public void returnMovieUnsuccessfullyReturnFalse() {
        assertThat(lib.returnMovie(movie.getTitle(), defaultLibraryNum), is(false));
    }

    @Test
    public void getUsersListReturnsDefaultLibraryMembers() {
        assertThat(lib.getUsersList(), hasItem(new User("004-1027", "pass", "John Smith", "j.smith@mail.com", "8903921")));
    }

    @Test
    public void getUserReturnsCorrectUser() {
        User u = lib.getUser("004-1027", "pass");
        assertThat(u.getLibraryNumber(), is("004-1027"));
        assertThat(u.getPassword(), is("pass"));
    }

}
