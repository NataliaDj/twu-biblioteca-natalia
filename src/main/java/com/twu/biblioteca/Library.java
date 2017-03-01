package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private List<Book> bookList;
    private List<Book> checkedoutBookList;
    private List<Movie> movieList;
    private List<Movie> checkedoutMovieList;
    private List<User> usersList;

    public Library(List<Book> booksList, List<Movie> moviesList, List<User> usersList) {
        this.bookList = booksList;
        this.checkedoutBookList = new ArrayList<Book>();
        this.movieList = moviesList;
        this.checkedoutMovieList = new ArrayList<Movie>();
        this.usersList = usersList;
    }

    public static Library defaultLibrary() {
        List<Book> booksList = new ArrayList<Book>(
                Arrays.asList(
                    new Book("A Study in Scarlet", "Sir Arthur Conan Doyle", 1887),
                    new Book("The Little White Bird", "J. M. Barrie", 1902),
                    new Book("Les Miserables", "Victor Hugo", 1862),
                    new Book("Don't Make Me Think Revisited", "Steve Krug", 2014),
                    new Book("The Little Mermaid", "Hans Christian Andersen", 1837),
                    new Book("Hamlet", "William Shakespeare", 1603)
                )
        );

        List<Movie> moviesList = new ArrayList<Movie>(
                Arrays.asList(
                        new Movie("Jaws", "Steven Spielberg", 1975, 8),
                        new Movie("The Lion King", "Roger Allers", 1994, 9),
                        new Movie("Letters To Juliet", "Gary Winick", 2010, 7),
                        new Movie("Imitation Game", "Morten Tyldum", 2014, 8)
                )
        );

        List<User> usersList = new ArrayList<User>(
                Arrays.asList(
                        new User("004-1027", "pass"),
                        new User("210-3201", "pass1"),
                        new User("100-0420", "pass2"),
                        new User("186-6749", "pass3")
                )
        );

        return new Library(booksList, moviesList, usersList);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public boolean checkoutBook(String title) {
        int pos = this.getTitlePosition(title, this.bookList);

        if (pos < this.bookList.size()) {
            Book book = this.bookList.remove(pos);
            this.checkedoutBookList.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title) {
        int pos = this.getTitlePosition(title, this.checkedoutBookList);

        if (pos < this.checkedoutBookList.size()) {
            Book book = this.checkedoutBookList.remove(pos);
            this.bookList.add(book);
            return true;
        }
        return false;
    }

    public List<Movie> getMoviesList() {
        return this.movieList;
    }

    public void addMovie(Movie movie) {
        this.movieList.add(movie);
    }

    public boolean checkoutMovie(String title) {
        int pos = getTitlePosition(title, this.movieList);

        if (pos < this.movieList.size()) {
            Movie movie = this.movieList.remove(pos);
            this.checkedoutMovieList.add(movie);
            return true;
        }
        return false;
    }

    public boolean returnMovie(String title) {
        int pos = this.getTitlePosition(title, this.checkedoutMovieList);

        if (pos < this.checkedoutMovieList.size()) {
            Movie movie = this.checkedoutMovieList.remove(pos);
            this.movieList.add(movie);
            return true;
        }
        return false;
    }

    public int getTitlePosition(String title, List<? extends LibraryItem> list) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                break;
            }
        }

        return i;

    }

    public List<User> getUsersList() {
        return this.usersList;
    }

}
