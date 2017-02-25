package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library lib;
    private Menu menu;
    private boolean run = true;

    public static void main(String[] args) {
        BibliotecaApp app = BibliotecaApp.defaultBibliotecaApp();
        app.run();
    }

    public BibliotecaApp(Library library) {
        this.lib = library;
        this.menu = Menu.defaultMenu();

    }

    public static BibliotecaApp defaultBibliotecaApp() {
        return new BibliotecaApp(Library.defaultLibrary());
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public String getMenuOptionResult(String option) {
        if (option.equals(Menu.LIST_BOOKS)) {
            return listAvailableBooks();
        } else if (option.matches(Menu.CHECKOUT + "[A-Za-z ]*")) {
            String result = "That book is not available.";
            int beginIndex = Menu.CHECKOUT.length() + 1;
            if (option.length() > beginIndex) {
                result = this.checkoutBook(option.substring(beginIndex));
            }
            return result;
        } else if (option.matches(Menu.RETURN + "[A-Za-z ]*")) {
            String result = "That is not a valid book to return.";
            int beginIndex = Menu.RETURN.length() + 1;
            if (option.length() > beginIndex)
                result = this.returnBook(option.substring(beginIndex));
            return result;
        } else if (option.equals(Menu.QUIT)) {
            run = false;
            return "";
        }
        return "Select a valid option!";
    }

    public boolean isRunning() {
        return run;
    }

    public void run() {
        System.out.println(this.getWelcomeMessage());

        while(this.isRunning()) {
            System.out.println(this.viewMenuOptions());

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(this.getMenuOptionResult(input));
        }
    }

    public String viewMenuOptions() {
        String result = "Options:\n";
        int counter = 1;
        for (String option: menu.getMenuOptions()) {
            result += counter + ". " +option + "\n";
            counter++;
        }
        return result.trim();
    }

    private String checkoutBook(String title) {
        if (lib.checkoutBook(title)) {
            return "Thank you! Enjoy the book";
        } else {
            return "That book is not available.";
        }
    }

    private String returnBook(String title) {
        if (lib.returnBook(title)) {
            return "Thank you for returning the book.";
        } else {
            return "That is not a valid book to return.";
        }
    }

    private String listAvailableBooks() {
        String result = "";
        for (Book book : lib.getBookList()) {
            result += book.getDetails() + "\n";
        }
        return result.trim();
    }
}
