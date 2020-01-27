package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.UserRepository;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class ReturnMovieOptionTest {
    Printer printer;
    BufferedReader reader;
    Library<Movie> movieLibrary;
    ReturnMovieOption returnMovieOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        movieLibrary = mock(Library.class);
        returnMovieOption = new ReturnMovieOption(printer, reader, movieLibrary);
    }

    @Test
    public void shouldCheckoutSelectedItem () throws IOException, InvalidItem, SessionException {
        int movieNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(movieNumber));

        returnMovieOption.execute();

        verify(movieLibrary).returnItem(movieNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(movieLibrary);
    }
}
