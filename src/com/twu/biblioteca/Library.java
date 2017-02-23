package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private List<Book> bookList;
    private List<Book> checkedoutList;

    public Library(List<Book> booksList) {
        bookList = booksList;
        checkedoutList = new ArrayList<Book>();
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

        return new Library(booksList);
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

}
