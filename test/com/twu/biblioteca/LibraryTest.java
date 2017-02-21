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
    public void getBookListReturnsAList() {
        Library lib = new Library();
        assertThat(lib.getBookList(), instanceOf(java.util.List.class));
    }

    @Test
    public void addBookAddsTheBookToBookList() {
        Library lib = new Library();
        lib.addBook(Book());
        assertThat(lib.getBookList().size(), is(1));
    }
}
