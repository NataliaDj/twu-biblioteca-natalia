package main.java.com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private List<Book> bookList;
    private List<Book> checkedoutList;
    private List<Movie> movieList;

    public Library(List<Book> booksList, List<Movie> moviesList) {
        this.bookList = booksList;
        this.checkedoutList = new ArrayList<Book>();
        this.movieList = moviesList;
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

        return new Library(booksList, moviesList);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public boolean checkoutBook(String title) {
        int i = 0;
        for (; i < this.bookList.size(); i++) {
            if (this.bookList.get(i).getTitle().equals(title)) {
                break;
            }
        }

        if (i < this.bookList.size()) {
            Book book = this.bookList.remove(i);
            this.checkedoutList.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title) {
        int i = 0;
        for (; i < this.checkedoutList.size(); i++) {
            if (this.checkedoutList.get(i).getTitle().equals(title))
                break;
        }

        if (i < this.checkedoutList.size()) {
            Book book = this.checkedoutList.remove(i);
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
        int i = 0;
        for (; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getTitle().equals(title)) {
                break;
            }
        }

        if (i < this.movieList.size()) {
            this.movieList.remove(i);
            return true;
        }
        return false;
    }

}
