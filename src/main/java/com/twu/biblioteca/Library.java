package com.twu.biblioteca;

import java.util.*;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private List<LibraryItem> items;
    private List<User> usersList;

    public Library(List<Book> booksList, List<Movie> moviesList, List<User> usersList) {
        items = new ArrayList<LibraryItem>();
        items.addAll(booksList);
        items.addAll(moviesList);

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
                    new User("004-1027", "pass", "John Smith", "j.smith@mail.com", "8903921"),
                    new User("210-3201", "pass1", "Mary Jane", "plainjane@email.com", "06782911"),
                    new User("100-0420", "pass2", "Frederick Roberts", "freddie.r@rocketmail.com", "39274812"),
                    new User("186-6749", "pass3", "Bethany Sue", "beths@workmail.com", "017620371")
                )
        );

        return new Library(booksList, moviesList, usersList);
    }

    public List<Book> getBookList() {
        List<Book> availableBooks = new ArrayList<Book>();

        for (LibraryItem item: this.items) {
            if (item.getType() == LibraryItem.Type.BOOK && item.isAvailable())
                availableBooks.add((Book) item);
        }

        return availableBooks;
    }

    public List<Movie> getMoviesList() {
        List<Movie> availableMovies = new ArrayList<Movie>();

        for (LibraryItem item: this.items) {
            if (item.getType() == LibraryItem.Type.MOVIE && item.isAvailable())
                availableMovies.add((Movie) item);
        }

        return availableMovies;
    }

    public void addBook(Book book) {
        addLibraryItem(book);
    }

    public void addMovie(Movie movie) {
        addLibraryItem(movie);
    }

    private void addLibraryItem(LibraryItem item) {
        this.items.add(item);
    }

    public boolean checkoutBook(String title, String libraryNum) {
        return checkoutItem(title, libraryNum, LibraryItem.Type.BOOK);
    }

    public boolean checkoutMovie(String title, String libraryNum) {
        return checkoutItem(title, libraryNum, LibraryItem.Type.MOVIE);
    }

    private boolean checkoutItem(String title, String libraryNum, LibraryItem.Type type) {
        isValidLibraryNum(libraryNum);
        // Find the item in list
        for (LibraryItem item: this.items) {
            if (item.getTitle().equals(title) && item.getType() == type) {

                // Checkout only if available
                if (item.isAvailable()) {
                    item.checkoutItem(libraryNum);
                    return true;
                }
                break;
            }
        }
        return false;
    }


    public boolean returnBook(String title, String libraryNum) {
        return returnItem(title, libraryNum, LibraryItem.Type.BOOK);
    }

    public boolean returnMovie(String title, String libraryNum) {
        return returnItem(title, libraryNum, LibraryItem.Type.MOVIE);
    }

    private boolean returnItem(String title, String libraryNum, LibraryItem.Type type) {
        isValidLibraryNum(libraryNum);
        // Find the item in list
        for (LibraryItem item: this.items) {
            if (item.getType() == type && item.getTitle().equals(title)) {

                // Return only if the it's checked-out
                if (item.isCheckedout()) {
                    return item.returnItem(libraryNum);
                }
                break;
            }
        }
        return false;
    }

    public List<User> getUsersList() {
        return this.usersList;
    }

    public User getUser(String libraryNum, String password) {
        for (User u: this.usersList) {
            if (libraryNum.equals(u.getLibraryNumber()) &&
                    password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public boolean isValidLibraryNum(String libraryNum) {
        for (User u: this.usersList) {
            if (libraryNum.equals(u.getLibraryNumber())) {
                return true;
            }
        }
        return false;

    }

    public String getCheckedoutBooksDetails() {
        return getCheckedoutItemDetails(LibraryItem.Type.BOOK);
    }

    public String getCheckedoutMoviesDetails() {
        return getCheckedoutItemDetails(LibraryItem.Type.MOVIE);
    }

    private String getCheckedoutItemDetails(LibraryItem.Type type) {
        String result = "";
        for (LibraryItem item: this.items) {
            if (item.getType() == type && item.isCheckedout()) {
                result += item.getTitle() + " - " + item.getCheckoutDetail() + "\n";
            }
        }
        return result;
    }
}
