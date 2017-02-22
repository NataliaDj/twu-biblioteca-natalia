package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Book> checkedoutList;

    public Library() {
        bookList = new ArrayList<Book>();
        checkedoutList = new ArrayList<Book>();

        initSampleBookList();
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

    private void initSampleBookList() {
        this.bookList.add(new Book("A Study in Scarlet", "Sir Arthur Conan Doyle", 1887));
        this.bookList.add(new Book("The Little White Bird", "J. M. Barrie", 1902));
        this.bookList.add(new Book("Les Miserables", "Victor Hugo", 1862));
        this.bookList.add(new Book("Don't Make Me Think Revisited", "Steve Krug", 2014));
        this.bookList.add(new Book("The Little Mermaid", "Hans Christian Andersen", 1837));
        this.bookList.add(new Book("Hamlet", "William Shakespeare", 1603));
    }

}
