package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ndjohari on 1/3/17.
 */
public class UserTest {
    String username;
    String password;
    User user;

    @Before
    public void setup() {
        username = "user";
        password = "pass";
        user = new User(username, password);
    }

    @Test
    public void getUsernameReturnsUsernameString() {
        assertThat(user.getUsername(), is(username));
    }

    @Test
    public void getPasswordReturnsPasswordString() {
        assertThat(user.getPassword(), is(password));
    }
}
