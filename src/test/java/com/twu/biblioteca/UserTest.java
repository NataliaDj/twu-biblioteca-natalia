package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ndjohari on 1/3/17.
 */
public class UserTest {
    @Test
    public void getUsernameReturnsUsernameString() {
        String username = "user";
        User user = new User(username, "pass");
        assertThat(user.getUsername(), is(username));
    }

    @Test
    public void getPasswordReturnsPasswordString() {
        String password = "pass";
        User user = new User("user", password);
        assertThat(user.getPassword(), is(password));
    }
}
