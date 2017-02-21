package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class LibraryTest {
    Library lib;

    @Before
    public void setup() {
        lib = new Library();
    }

    @Test
    public void getBookListReturnsAListTest() {
        assertThat(lib.getBookList(), instanceOf(java.util.List.class));
    }

    @Test
    public void addBookAddsTheBookToBookListTest() {
        lib.addBook(new Book());
        assertThat(lib.getBookList().size(), is(1));
    }

    //test library contains book that was added
    @Test
    public void addBookAddsSameBookToBookListTest() {
        Book book = new Book("Call of The Wild");
        lib.addBook(book);
        assertThat(lib.getBookList(), hasItem(book));
    }

    //test add book does not change other books in library
}
