package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private Library lib;
    private boolean run = true;
    private User user;

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

            if (!chosenOption.isBasic() && !isLoggedIn()) {
                return "Please login first";
            }

            String param = this.getCommandParam(option, chosenOption);
            switch (chosenOption) {
                case LIST_BOOKS:
                    return this.listAvailableBooks();
                case QUIT:
                    run = false;
                    return "";
                case CHECKOUT_BOOK:
                    return this.checkoutBook(param);
                case RETURN_BOOK:
                    return this.returnBook(param);
                case LIST_MOVIES:
                    return this.listAvailableMovies();
                case CHECKOUT_MOVIE:
                    return this.checkoutMovie(param);
                case RETURN_MOVIE:
                    return this.returnMovie(param);
                case LOGIN:
                    return this.login(param);
                case LOGOUT:
                    return this.logout();

            }
        }
        return "Select a valid option!";
    }

    public boolean isRunning() {
        return run;
    }

    public boolean isLoggedIn() {
        return user != null;
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

        List<String> menuOption;
        if (isLoggedIn()) {
            menuOption = Menu.getFullMenuOptionsList();
        } else {
            menuOption = Menu.getBasicMenuOptionsList();
        }

        for (String option: menuOption) {
            result += counter + ". " +option + "\n";
            counter++;
        }
        return result.trim();
    }

    private String checkoutBook(String title) {
        if (lib.checkoutBook(title, user.getLibraryNumber())) {
            return checkoutSuccessfulMessage("book");
        } else {
            return checkoutFailMessage("book");
        }
    }

    private String returnBook(String title) {
        if (lib.returnBook(title)) {
            return returnSuccessfulMessage("book");
        } else {
            return returnFailMessage("book");
        }
    }

    private String checkoutMovie(String title) {
        if (lib.checkoutMovie(title, user.getLibraryNumber())) {
            return checkoutSuccessfulMessage("movie");
        } else {
            return checkoutFailMessage("movie");
        }
    }

    private String returnMovie(String title) {
        if (lib.returnMovie(title)) {
            return returnSuccessfulMessage("movie");
        } else {
            return returnFailMessage("movie");
        }
    }

    public String returnSuccessfulMessage(String type) {
        return "Thank you for returning the " + type + ".";
    }

    public String returnFailMessage(String type) {
        return "That is not a valid " + type + " to return.";
    }

    private String checkoutSuccessfulMessage(String type) {
        return "Thank you! Enjoy the " + type;
    }

    private String checkoutFailMessage(String type) {
        return "That " + type + " is not available.";
    }



    private String getCommandParam(String command, Menu.Option optionType) {
        int beginIndex = optionType.length() + 1;
        if (command.length() > beginIndex)
            return command.substring(beginIndex);
        return "";
    }

    private String listAvailableBooks() {
        String result = "";
        for (Book book : lib.getBookList()) {
            result += book.getDetails() + "\n";
        }
        return result.trim();
    }

    private String listAvailableMovies() {
        String result = "";
        for (Movie movie : lib.getMoviesList()) {
            result += movie.getDetails() + "\n";
        }
        return result.trim();
    }

    public String login(String credentials) {
        String[] params = credentials.split(" ");
        String libraryNum = params[0];
        String password = "";

        try {
            password = params[1];
        } catch (Exception e) {

        }

        return login(libraryNum, password);
    }

    public String login(String librarynum, String password) {
        this.user = lib.getUser(librarynum, password);
        if (isLoggedIn()) {
            return "Welcome ";
        } else {
            return "Login failed. Please try again";
        }
    }

    public String logout() {
        this.user = null;
        return "Logout Successful";
    }

    public String listCheckedOut() {
        String result = "Books:\n";
        result += lib.getCheckedoutBooksDetails();

        result += "\nMovies:\n";
        result += lib.getCheckedoutMoviesDetails();

        return result;
    }
}
