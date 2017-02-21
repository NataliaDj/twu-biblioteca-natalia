package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

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
        assertThat(new Book(), equalTo (new Book()));
    }

    @Test
    public void twoBooksWithDifferentTitleAreNotEqualTest() {
        assertThat(new Book("Pride and Prejudice"), not(equalTo(new Book("Hamlet"))) );
    }

    @Test
    public void getAuthorReturnBookAuthorTest() {
        String author = "J. K. Rowling";
        Book book = new Book();
        book.setTitle(author);
        assertThat(book.getAuthor(), is(author));
    }

}
