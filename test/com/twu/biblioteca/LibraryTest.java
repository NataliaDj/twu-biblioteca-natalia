package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class LibraryTest {

    @Test
    public void getBookListReturnsAListTest() {
        Library lib = new Library();
        assertThat(lib.getBookList(), instanceOf(java.util.List.class));
    }

    @Test
    public void addBookAddsTheBookToBookListTest() {
        Library lib = new Library();
        lib.addBook(new Book());
        assertThat(lib.getBookList().size(), is(1));
    }

    //test library contains book that was added

    //test add book does not change other books in library
}
