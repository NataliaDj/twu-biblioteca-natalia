package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    ArrayList bookList;

    public Library() {
        bookList = new ArrayList();
    }

    public List getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

}
