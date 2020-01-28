package com.twu.biblioteca.options;

import com.twu.biblioteca.Constants;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.Reader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogInOptionTest {
    Printer printer;
    Reader reader;
    LogInOption logInOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(Reader.class);
        logInOption = new LogInOption(printer, reader);
    }

    @Test
    public void shouldLogInWithValidCredentials () throws IOException {
        when(reader.readStr()).thenReturn("111-1111", "111");

        logInOption.execute();

        verify(printer).print(Constants.SUCCESS_LOGIN);
    }

    @Test
    public void shouldNotLogInWithInvalidCredentials () {
        logInOption.execute();

        verify(printer).print(Constants.ERROR_INVALID_CREDENTIALS);
    }
}
