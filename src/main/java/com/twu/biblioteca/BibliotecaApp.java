package main.java.com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library lib;
    private boolean run = true;

    public static void main(String[] args) {
        BibliotecaApp app = BibliotecaApp.defaultBibliotecaApp();
        app.run();
    }

    public BibliotecaApp(Library library) {
        this.lib = library;

    }

    public static BibliotecaApp defaultBibliotecaApp() {
        return new BibliotecaApp(Library.defaultLibrary());
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public String getMenuOptionResult(String option) {
        Menu.Option chosenOption = Menu.toOption(option);
        if (chosenOption != null) {

            switch (chosenOption) {
                case LIST_BOOKS:
                    return listAvailableBooks();
                case QUIT:
                    run = false;
                    return "";
                case CHECKOUT:
                    String result = "That book is not available.";
                    int beginIndex = Menu.Option.CHECKOUT.length() + 1;
                    if (option.length() > beginIndex) {
                        result = this.checkoutBook(option.substring(beginIndex));
                    }
                    return result;
                case RETURN:
                    result = "That is not a valid book to return.";
                    beginIndex = Menu.Option.RETURN.length() + 1;
                    if (option.length() > beginIndex)
                        result = this.returnBook(option.substring(beginIndex));
                    return result;
            }
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
        for (String option: Menu.getMenuOptionsList()) {
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
