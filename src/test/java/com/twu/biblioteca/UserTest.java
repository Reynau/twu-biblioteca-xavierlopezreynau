package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void shouldReturnSerializedBook () {
        User user = new User("u1");

        String serializedUser = user.serialize();

        String expected = "u1";
        assertThat(serializedUser, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = User.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }
}
