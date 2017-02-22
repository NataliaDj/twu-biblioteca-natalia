package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final String LIST_BOOKS = "List Books";
    private final String QUIT = "Quit";
    private Library lib;
    private List<String> menuOptions;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.getWelcomeMessage());

    }

    public BibliotecaApp() {
        this.lib = new Library();
        this.menuOptions = new ArrayList<String>();

        menuOptions.add(LIST_BOOKS);
        menuOptions.add(QUIT);

    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca\n";
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

    public String getMenuOptionResult(String option) {
        if (option == LIST_BOOKS) {
            String result = "";
            for (Book book: lib.getBookList()) {
                result += book.getDetails() + "\n";
            }
            return result;
        } else if (option == QUIT) {
            return "";
        }
        return "Select a valid option!";
    }

    public boolean isRunning() {
        return true;
    }
}
