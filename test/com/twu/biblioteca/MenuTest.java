package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class MenuTest {
    private Menu menu;

    @Before
    public void setup() {
        menu = new Menu();
    }

    @Test
    public void getMenuOptionsContainsAllOptionString() {
        assertThat(menu.getMenuOptionsList(), hasItem("List Books"));
        assertThat(menu.getMenuOptionsList(), hasItem("Quit"));
        assertThat(menu.getMenuOptionsList(), hasItem("Checkout"));
        assertThat(menu.getMenuOptionsList(), hasItem("Return"));
    }

    @Test
    public void getOptionListBooksReturnsListBookOption() {
        assertThat(Menu.toOption("List Books"), is(Menu.Option.LIST_BOOKS));
    }

    @Test
    public void getOptionQuitReturnsQuitOption() {
        assertThat(Menu.toOption("Quit"), is(Menu.Option.QUIT));
    }

    @Test
    public void getOptionCheckoutTitleReturnsCheckoutOption() {
        assertThat(Menu.toOption("Checkout Book Title"), is(Menu.Option.CHECKOUT));
    }

    @Test
    public void getOptionReturnTitleReturnsReturnOption() {
        assertThat(Menu.toOption("Return Book Title"), is(Menu.Option.RETURN));
    }
}
