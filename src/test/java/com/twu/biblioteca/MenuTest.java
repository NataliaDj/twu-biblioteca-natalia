package test.java.com.twu.biblioteca;

import main.java.com.twu.biblioteca.Menu;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nataliadjohari on 22/02/2017.
 */
public class MenuTest {

    @Test
    public void getMenuOptionsContainsAllOptionString() {
        assertThat(Menu.getMenuOptionsList(), hasItem("List Books"));
        assertThat(Menu.getMenuOptionsList(), hasItem("List Movies"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Quit"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Checkout"));
        assertThat(Menu.getMenuOptionsList(), hasItem("Return"));
    }

    @Test
    public void getOptionListBooksReturnsListBookOption() {
        assertThat(Menu.toOption("List Books"), is(Menu.Option.LIST_BOOKS));
    }

    @Test
    public void getOptionListMoviesReturnsListMovieOption() {
        assertThat(Menu.toOption("List Books"), is(Menu.Option.LIST_MOVIE));
    }

    @Test
    public void getOptionQuitReturnsQuitOption() {
        assertThat(Menu.toOption("Quit"), is(Menu.Option.QUIT));
    }

    @Test
    public void getOptionCheckoutTitleReturnsCheckoutOption() {
        assertThat(Menu.toOption("Checkout Book Title"), is(Menu.Option.CHECKOUT));
    }

    @Test
    public void getOptionReturnTitleReturnsReturnOption() {
        assertThat(Menu.toOption("Return Book Title"), is(Menu.Option.RETURN));
    }
}
