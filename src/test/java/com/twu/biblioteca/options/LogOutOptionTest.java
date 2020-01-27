package com.twu.biblioteca.options;

import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogOutOptionTest {
    Printer printer;
    BufferedReader reader;
    LogInOption logInOption;
    LogOutOption logOutOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        logInOption = new LogInOption(printer, reader);
        logOutOption = new LogOutOption(printer);
    }

    @Test
    public void shouldLogInWithValidCredentials () throws IOException {
        when(reader.readLine()).thenReturn("u1", "p1");
        logInOption.execute();

        logOutOption.execute();
        verify(printer).print("Logged out successfully!");
    }
}
