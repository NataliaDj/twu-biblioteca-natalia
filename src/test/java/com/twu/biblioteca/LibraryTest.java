package test.java.com.twu.biblioteca;

import main.java.com.twu.biblioteca.Book;
import main.java.com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by nataliadjohari on 21/02/2017.
 */
public class LibraryTest {
    Library lib;

    @Before
    public void setup() {
        lib = Library.defaultLibrary();
    }

    @Test
    public void getBookListReturns0ForEmptyLibraryTest() {
        lib = new Library(new ArrayList<Book>());
        assertThat(lib.getBookList().size(), is(0));
    }

    @Test
    public void getDefaultBookListReturnNotEmptyList() {
        assertThat(lib.getBookList().size(), not(is(0)));
    }

    @Test
    public void addBookAddsTheBookToBookListTest() {
        int initialSize = lib.getBookList().size();
        lib.addBook(new Book());
        assertThat(lib.getBookList().size(), is(initialSize + 1));
    }

    //test library contains book that was added
    @Test
    public void addBookAddsSameBookToBookListTest() {
        Book book = new Book("Call of The Wild");
        lib.addBook(book);
        assertThat(lib.getBookList(), hasItem(book));
    }

    //test add book does not change other books in library
    @Test
    public void addBookDoesNotChangeOtherBooksInListTest() {
        Book firstBook = new Book("Hamlet");
        Book secondBook = new Book("Lion King");
        lib.addBook(firstBook);
        lib.addBook(secondBook);
        assertThat(lib.getBookList(), hasItems(firstBook, secondBook));
    }

    @Test
    public void checkoutBookRemovesBookFromList() {
        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        lib.checkoutBook(title);
        assertThat(lib.getBookList(), not(hasItem(book)));
    }

    @Test
    public void checkoutBookSuccessfullyReturnsTrue() {
        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        assertThat(lib.checkoutBook(title), is(true));
    }


    @Test
    public void checkoutBookUnsuccessfullyReturnsFalseTest() {
        String title = "Three Blind Mice";
        assertThat(lib.checkoutBook(title), is(false));
    }

    @Test
    public void returnBookInsertsBookToBookListTest() {
        String title = "Three Blind Mice";
        Book book = new Book(title);
        lib.addBook(book);
        lib.checkoutBook(title);
        lib.returnBook(title);
        assertThat(lib.getBookList(), hasItem(book));
    }

    @Test
    public void returnBookSuccessfullyReturnsTrue() {
        String title = "Three Blind Mice";
        lib.addBook(new Book(title));
        lib.checkoutBook(title);
        assertThat(lib.returnBook(title), is(true));
    }

    @Test
    public void returnBookUnsuccessfullyReturnFalse() {
        assertThat(lib.returnBook("Three Blind Mice"), is(false));
    }
}
