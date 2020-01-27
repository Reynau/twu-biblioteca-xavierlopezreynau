package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = UserRepository.userRepository;
    }

    @Test
    public void shouldLogInWhenUserCredentialsExist () {
        boolean userLogged = userRepository.logIn("u1:p1");
        assertThat(userLogged, is(true));
    }

    @Test
    public void shouldNotLogInWhenUserCredentialsDontExist () {
        boolean userLogged = userRepository.logIn("u0:p1");
        assertThat(userLogged, is(false));
    }

    @Test
    public void shouldReturnNullWhenUserIsNotLoggedIn() {
        User user = userRepository.getLoggedUser();

        assertThat(user, is(nullValue()));
    }

    @Test
    public void shouldReturnUserWhenUserIsLoggedIn() {
        userRepository.logIn("u1:p1");
        User user = userRepository.getLoggedUser();

        assertThat(user.serialize(), is("u1"));
    }

    @Test
    public void shouldReturnNullWhenUserLogOut() {
        userRepository.logIn("u1:p1");
        userRepository.logOut();
        User user = userRepository.getLoggedUser();

        assertThat(user, is(nullValue()));
    }
}
