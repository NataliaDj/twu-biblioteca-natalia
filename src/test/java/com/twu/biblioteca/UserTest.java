package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
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
        name = "Byron Li";
        email = "bli@somemail.com";
        phone = "7927192";
        user = new User(librarynum, password, name, email, phone);
    }

    @Test
    public void constructUserWithWrongLibraryNumFormatThrowsIllegalArgumentException() {
        try {
            new User("1234567", password, name, email, phone);
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
        User user2 = new User(librarynum, password, name, email, phone);
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
        assertThat(user.getPhone(), is(phone));
    }

    @Test
    public void getDetailsContainsAllDetailsString() {
        String result = user.getDetails();

        assertThat(result, containsString(librarynum));
        assertThat(result, containsString(name));
        assertThat(result, containsString(email));
        assertThat(result, containsString(phone));
    }

}
