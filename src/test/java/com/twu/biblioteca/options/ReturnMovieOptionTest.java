package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ReturnMovieOptionTest {
    Printer printer;
    Reader reader;
    Library<Movie> movieLibrary;
    ReturnMovieOption returnMovieOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(Reader.class);
        movieLibrary = mock(Library.class);
        returnMovieOption = new ReturnMovieOption(printer, reader, movieLibrary);
    }

    @Test
    public void shouldCheckoutSelectedItem () throws IOException, InvalidItem, SessionException {
        int movieNumber = 1;
        when(reader.readInt()).thenReturn(movieNumber);

        returnMovieOption.execute();

        verify(movieLibrary).returnItem(movieNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(movieLibrary);
    }
}
