package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library lib;
    private Menu menu;
    private boolean run = true;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.print(app.getWelcomeMessage());

        while(app.isRunning()) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(app.getMenuOptionResult(input));
        }

    }

    public BibliotecaApp() {
        this.lib = new Library();
        this.menu = new Menu();

    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca\n";
    }

    public String getMenuOptionResult(String option) {
        if (option.equals(Menu.LIST_BOOKS)) {
            String result = "";
            for (Book book: lib.getBookList()) {
                result += book.getDetails() + "\n";
            }
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

    public String viewMenuOptions() {
        String result = "";
        for (String option: menu.getMenuOptions()) {
            result += option + "\n";
        }
        return result;
    }
}
