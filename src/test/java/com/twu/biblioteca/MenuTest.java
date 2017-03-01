package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class MenuTest {

    @Test
    public void getMenuOptionsContainsAllOptionString() {
        assertThat(Menu.getMenuOptionsList(), hasItem("List Books"));
        assertThat(Menu.getMenuOptionsList(), hasItem("List Movies"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Quit"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Checkout Book"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Return Book"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Checkout Movie"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Return Movie"));
    }

    @Test
    public void toOptionListBooksReturnsListBookOption() {
        assertThat(Menu.toOption("List Books"), is(Menu.Option.LIST_BOOKS));
    }

    @Test
    public void toOptionListMoviesReturnsListMovieOption() {
        assertThat(Menu.toOption("List Movies"), is(Menu.Option.LIST_MOVIES));
    }

    @Test
    public void toOptionQuitReturnsQuitOption() {
        assertThat(Menu.toOption("Quit"), is(Menu.Option.QUIT));
    }

    @Test
    public void toOptionCheckoutBookTitleReturnsCheckoutBookOption() {
        assertThat(Menu.toOption("Checkout Book Title"), is(Menu.Option.CHECKOUT_BOOK));
    }

    @Test
    public void toOptionReturnBookTitleReturnsReturnBookOption() {
        assertThat(Menu.toOption("Return Book Title"), is(Menu.Option.RETURN_BOOK));
    }

    @Test
    public void toOptionCheckoutMovieTitleReturnsCheckoutMovieOption() {
        assertThat(Menu.toOption("Checkout Movie Title"), is(Menu.Option.CHECKOUT_MOVIE));
    }

    @Test
    public void toOptionReturnMovieTitleReturnsReturnMovieOption() {
        assertThat(Menu.toOption("Return Movie Title"), is(Menu.Option.RETURN_MOVIE));
    }
}
