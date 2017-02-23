package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class Menu {
    public static final String LIST_BOOKS = "List Books";
    public static final String QUIT = "Quit";
    public static final String CHECKOUT = "Checkout";
    public static final String RETURN = "Return";

    private List<String> menuOptions;

    public Menu(List<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public static Menu defaultMenu() {
        List<String> menuOptions = new ArrayList<String> (
            Arrays.asList(
                Menu.LIST_BOOKS,
                Menu.QUIT,
                Menu.CHECKOUT,
                Menu.RETURN
            )
        );
        return new Menu(menuOptions);
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
