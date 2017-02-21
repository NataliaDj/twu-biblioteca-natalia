package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class BooksListTest {

    @Test
    public void getBookListReturnsAList() {
        Library lib = new Library();
        assertThat(lib.getBookList(), instanceOf(java.util.List.class));
    }
}
