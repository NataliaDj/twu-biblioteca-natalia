package com.twu.biblioteca;

import org.junit.Test;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class BookTest {

    @Test
    public void emptyBookReturnEmptyStringTitle() {
        Book book = new Book();
        assertThat(book.getTitle(), is(""));
    }
}
