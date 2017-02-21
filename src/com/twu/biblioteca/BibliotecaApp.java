package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
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
        options.add("List Books");
        return options;
    }

    public String getSelectedMenuOptionResult(String option) {
        if (option == "List Books") {
            String result = "";
            for (Book book: lib.getBookList()) {
                result += book.getDetails() + "\n";
            }
            return result;
        }
        return null;
    }
}
