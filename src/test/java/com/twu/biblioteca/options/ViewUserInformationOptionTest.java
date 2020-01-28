package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
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
        UserRepository.userRepository.logIn(Data.users.get(0).getHash());
        User user = UserRepository.userRepository.getLoggedUser();

        viewUserInformationOption.execute();

        String userData = user.getData();
        verify(printer).print(userData);
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldNotPrintUserInformationWhenUserIsLoggedOut () {
        viewUserInformationOption.execute();

        verify(printer).print(Constants.ERROR_NOT_LOGGED_IN);
        verifyNoMoreInteractions(printer);
    }
}
