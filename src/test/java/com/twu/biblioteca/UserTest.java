package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ndjohari on 1/3/17.
 */
public class UserTest {
    String librarynum;
    String password;
    String name;
    String email;
    String phone;
    User user;

    @Before
    public void setup() {
        librarynum = "004-1027";
        password = "pass";
        user = new User(librarynum, password, name, email, phone);
    }

    @Test
    public void constructUserWithWrongLibraryNumFormatThrowsIllegalArgumentException() {
        try {
            new User("1234567", password);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getLibraryNumberReturnsLibraryNumberString() {
        assertThat(user.getLibraryNumber(), is(librarynum));
    }

    @Test
    public void getPasswordReturnsPasswordString() {
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void equalWithOtherUserWithSameLibraryNumberAndPasswordReturnsTrue() {
        User user2 = new User(librarynum, password);
        assertThat(user.equals(user2), is(true));
    }

    @Test
    public void getNameReturnsNameString() {
        assertThat(user.getName(), is(name));
    }

    @Test
    public void getEmailReturnsEmailString() {
        assertThat(user.getEmail(), is(email));
    }

    @Test
    public void getPhoneReturnsPhoneString() {
        assertThat(user.getName(), is(name));
    }

}
