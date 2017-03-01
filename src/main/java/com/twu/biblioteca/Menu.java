package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> getBasicMenuOptionsList() {
        List<String> options = new ArrayList<String>();
        for (Option o: Option.values()) {
            if (o.isBasic()) {
                options.add(o.toString());
            }
        }
        return options;
    }

    public static List<String> getFullMenuOptionsList() {
        List<String> options = new ArrayList<String>();
        for (Option o: Option.values()) {
            if (o == Option.LOGIN)
                continue;
            options.add(o.toString());
        }
        return options;
    }

    public static Option toOption(String command) {
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
