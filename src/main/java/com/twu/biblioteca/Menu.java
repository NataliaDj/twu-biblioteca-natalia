package main.java.com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class Menu {
    public enum Option {
        LIST_BOOKS("List Books"), CHECKOUT("Checkout Book"), RETURN("Return Book"),
        LIST_MOVIES("List Movies"),
        QUIT("Quit");
        private String name;
        Option(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public int length() {
            return name.length();
        }
    };

    public static List<String> getMenuOptionsList() {
        List<String> options = new ArrayList<String>();
        for (Option o: Option.values()) {
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
