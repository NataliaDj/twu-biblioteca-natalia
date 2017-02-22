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
    public void getMenuOptionsContainsListBooksString() {
        assertThat(menu.getMenuOptions(), hasItem("List Books"));
    }

    @Test
    public void isMenuOptionListBookReturnsTrueTest() {
        assertThat(menu.isMenuOption("List Books"), is(true));
    }

    @Test
    public void isMenuOptionEmptyStringReturnsFalseTest() {
        assertThat(menu.isMenuOption(""), is(false));
    }

    @Test
    public void isMenuOptionQuitReturnsTrueTest() {
        assertThat(menu.isMenuOption("Quit"), is(true));
    }
}
