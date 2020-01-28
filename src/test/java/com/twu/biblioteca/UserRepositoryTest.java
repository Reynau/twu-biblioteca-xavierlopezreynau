package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = UserRepository.userRepository;
    }

    @Test
    public void shouldLogInWhenUserCredentialsExist () {
        boolean userLogged = userRepository.logIn(Data.users.get(0).getHash());
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
        userRepository.logIn(Data.users.get(0).getHash());
        User user = userRepository.getLoggedUser();

        assertThat(user, is(not(nullValue())));
        assertThat(user.serialize(), is("Fahad Shepard"));
    }

    @Test
    public void shouldReturnNullWhenUserLogOut() {
        userRepository.logIn(Data.users.get(0).getHash());
        userRepository.logOut();
        User user = userRepository.getLoggedUser();

        assertThat(user, is(nullValue()));
    }
}
