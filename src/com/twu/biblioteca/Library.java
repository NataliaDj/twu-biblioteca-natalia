package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList();

        initSampleBookList();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    private void initSampleBookList() {
        this.bookList.add(new Book("A Study in Scarlet", "Sir Arthur Conan Doyle", 1887));
        this.bookList.add(new Book("The Little White Bird", "J. M. Barrie", 1902));
        this.bookList.add(new Book("Les Miserables", "Victor Hugo", 1862));
        this.bookList.add(new Book("Don't Make Me Think Revisited", "Steve Krug", 2014));
        this.bookList.add(new Book("The Little Mermaid", "Hans Christian Andersen", 1837));
        this.bookList.add(new Book("Hamlet", "William Shakespeare", 1603));
    }

}
