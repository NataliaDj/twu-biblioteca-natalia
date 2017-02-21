package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.getWelcomeMessage());

        Library lib = new Library();
        for (Book book: lib.getBookList()) {
            System.out.println(book.getTitle());
        }
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca\n";
    }
}
