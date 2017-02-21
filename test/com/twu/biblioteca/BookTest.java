package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class BookTest {

    @Test
    public void emptyBookReturnEmptyStringTitleTest() {
        Book book = new Book();
        assertThat(book.getTitle(), is(""));
    }

    @Test
    public void getTitleReturnsBookTitleTest() {
        String title = "Harry Potter and The Chamber of Secrets";
        Book book = new Book(title);
        assertThat(book.getTitle(), is(title));
    }

    @Test
    public void emptyBookIsEqualToAnotherEmptyBookTest() {
        assertThat(new Book(), is (new Book()));
    }

}
