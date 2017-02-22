package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class Menu {
    public static final String LIST_BOOKS = "List Books";
    public static final String QUIT = "Quit";
    public static final String CHECKOUT = "Checkout";

    private List<String> menuOptions;

    public Menu() {
        menuOptions = new ArrayList<String>();
        menuOptions.add(Menu.LIST_BOOKS);
        menuOptions.add(Menu.QUIT);
        menuOptions.add(Menu.CHECKOUT);
    }

    public List<String> getMenuOptions() {
        return this.menuOptions;
    }

    public boolean isMenuOption(String input) {
        for (String s: this.getMenuOptions()) {
            if (s.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public void add(String item) {
        this.menuOptions.add(item);
    }
}
