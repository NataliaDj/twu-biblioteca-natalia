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
    public void isMenuOptionOptionsTrueTest() {
        assertThat(menu.isMenuOption("List Books"), is(true));
        assertThat(menu.isMenuOption("Quit"), is(true));
        assertThat(menu.isMenuOption("Checkout"), is(true));
        assertThat(menu.isMenuOption("Return"), is(true));
    }

    @Test
    public void isMenuOptionEmptyStringReturnsFalseTest() {
        assertThat(menu.isMenuOption(""), is(false));
    }

    @Test
    public void isMenuOptionInvalidOptionReturnFalseTest() {
        assertThat(menu.isMenuOption("Add"), is(false));
        assertThat(menu.isMenuOption("Delete"), is(false));
        assertThat(menu.isMenuOption("1"), is(false));
        assertThat(menu.isMenuOption("list books"), is(false));
    }
}
