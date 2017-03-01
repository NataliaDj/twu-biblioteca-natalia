package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ndjohari on 1/3/17.
 */
public class UserTest {
    @Test
    public void getUsernameReturnsUsernameString() {
        String username = "user";
        User user = new User(username);
        assertThat(user.getUsername().length(), not(is(0)));
    }
}
