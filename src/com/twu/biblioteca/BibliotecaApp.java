package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final String LIST_BOOKS = "List Books";
    private final String QUIT = "Quit";
    Library lib;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.getWelcomeMessage());


    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca\n";
    }

    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<String>();
        options.add(LIST_BOOKS);
        options.add(QUIT);
        return options;
    }

    public String getSelectedMenuOptionResult(String option) {
        if (option == LIST_BOOKS) {
            String result = "";
            for (Book book: lib.getBookList()) {
                result += book.getDetails() + "\n";
            }
            return result;
        }
        return null;
    }

    public boolean isMenuOption(String input) {
        for (String s: this.getMenuOptions()) {
            if (s.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
