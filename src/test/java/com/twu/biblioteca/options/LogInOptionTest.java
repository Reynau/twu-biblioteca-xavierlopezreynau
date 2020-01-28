package com.twu.biblioteca.options;

import com.twu.biblioteca.Constants;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogInOptionTest {
    Printer printer;
    BufferedReader reader;
    LogInOption logInOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        logInOption = new LogInOption(printer, reader);
    }

    @Test
    public void shouldLogInWithValidCredentials () throws IOException {
        when(reader.readLine()).thenReturn("u1", "p1");
        logInOption.execute();

        verify(printer).print(Constants.SUCCESS_LOGIN);
    }

    @Test
    public void shouldNotLogInWithInvalidCredentials () {
        logInOption.execute();

        verify(printer).print(Constants.ERROR_INVALID_CREDENTIALS);
    }
}
