package com.twu.biblioteca;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class MenuTest {

    @Test
    public void getBasicMenuOptionsContainsLimitedOptionString() {
        List<String> options = Menu.getBasicMenuOptionsList();
        assertThat(options, hasItem("List Books"));
        assertThat(options, hasItem("List Movies"));
        assertThat(options, hasItem("List Checked Out Items"));
        assertThat(options, hasItem("Quit"));
        assertThat(options, hasItem("Login"));

        assertThat(options, not(hasItem("Logout")));
        assertThat(options, not(hasItem("Checkout Book")));
        assertThat(options, not(hasItem("Return Book")));
        assertThat(options, not(hasItem("Checkout Movie")));
        assertThat(options, not(hasItem("Return Movie")));
        assertThat(options, not(hasItem("View Details")));
    }

    @Test
    public void getFullMenuOptionsContainsAllOptionString() {
        List<String> options = Menu.getFullMenuOptionsList();
        assertThat(options, hasItem("List Books"));
        assertThat(options, hasItem("List Movies"));
        assertThat(options, hasItem("List Checked Out Items"));
        assertThat(options, hasItem("Quit"));
        assertThat(options, not(hasItem("Login")));

        assertThat(options, hasItem("Logout"));
        assertThat(options, hasItem("Checkout Book"));
        assertThat(options, hasItem("Return Book"));
        assertThat(options, hasItem("Checkout Movie"));
        assertThat(options, hasItem("Return Movie"));
        assertThat(options, hasItem("View Details"));
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

    @Test
    public void toOptioLoginReturnsLoginOption() {
        assertThat(Menu.toOption("Login"), is(Menu.Option.LOGIN));
    }

    @Test
    public void toOptionLogoutReturnsLogoutOption() {
        assertThat(Menu.toOption("Logout"), is(Menu.Option.LOGOUT));
    }

    @Test
    public void toOptionListCheckeOutItemReturnsListCheckedoutOption() {
        assertThat(Menu.toOption("List Checked Out Items"), is(Menu.Option.LIST_CHECKEDOUT));
    }

    @Test
    public void toOptionsViewDetailsReturnsViewDetailsOption() {
        assertThat(Menu.toOption("View Details"), is(Menu.Option.VIEW_DETAILS));
    }

}
