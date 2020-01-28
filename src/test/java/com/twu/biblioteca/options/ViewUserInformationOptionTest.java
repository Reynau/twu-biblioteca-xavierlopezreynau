package com.twu.biblioteca.options;

import com.twu.biblioteca.Printer;
import com.twu.biblioteca.User;
import com.twu.biblioteca.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ViewUserInformationOptionTest {
    Printer printer;
    ViewUserInformationOption viewUserInformationOption;

    @Before
    public void setUp() throws Exception {
        printer = mock(Printer.class);
        viewUserInformationOption = new ViewUserInformationOption(printer);
    }

    @Test
    public void shouldPrintUserInformationWhenUserIsLoggedIn () {
        UserRepository.userRepository.logIn("u1:p1");
        User user = UserRepository.userRepository.getLoggedUser();

        viewUserInformationOption.execute();

        verify(printer).print(user.getData());
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldNotPrintUserInformationWhenUserIsLoggedOut () {
        viewUserInformationOption.execute();

        verify(printer).print("You need to be logged in!");
        verifyNoMoreInteractions(printer);
    }
}
