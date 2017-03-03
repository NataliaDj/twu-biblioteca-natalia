package com.twu.biblioteca;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.twu.biblioteca.Menu.Option.*;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class Menu {
    public enum Option {
        LIST_BOOKS("List Books", true), CHECKOUT_BOOK("Checkout Book", false), RETURN_BOOK("Return Book", false),
        LIST_MOVIES("List Movies", true), CHECKOUT_MOVIE("Checkout Movie", false), RETURN_MOVIE("Return Movie", false),
        LIST_CHECKEDOUT("List Checked Out Items", true),
        LOGIN("Login", true), LOGOUT("Logout", false),
        VIEW_DETAILS("View Details", false), QUIT("Quit", true);
        private String name;
        private boolean basic;
        Option(String name, boolean basic) {
            this.name = name;
            this.basic = basic;
        }

        @Override
        public String toString() {
            return name;
        }

        public int length() {
            return name.length();
        }

        public boolean isBasic() {
            return basic;
        }
    };

    private static List<String> fullList = new ArrayList<String>(
            Arrays.asList(
                    LIST_BOOKS.toString(),
                    LIST_MOVIES.toString(),
                    LIST_CHECKEDOUT.toString(),
                    LOGIN.toString(),
                    QUIT.toString()
            )
    );
    private static List<String> basicList = new ArrayList<String>(
            Arrays.asList(
                    LIST_BOOKS.toString(),
                    LIST_MOVIES.toString(),
                    LIST_CHECKEDOUT.toString(),
                    CHECKOUT_BOOK.toString(),
                    RETURN_BOOK.toString(),
                    CHECKOUT_MOVIE.toString(),
                    RETURN_MOVIE.toString(),
                    VIEW_DETAILS.toString(),
                    LOGOUT.toString(),
                    QUIT.toString()
            )
    );

    public static List<String> getBasicMenuOptionsList() {
        return fullList;
    }

    public static List<String> getFullMenuOptionsList() {
        return basicList;
    }

    public static Option valueOf(String command) {
        for (Option o: Option.values()) {
            try {
                String chosenOption = command.substring(0, o.length());
                if (o.toString().equals(chosenOption)) {
                    return o;
                }
            } catch (Exception e) {

            }
        }
        return null;
    }
}
