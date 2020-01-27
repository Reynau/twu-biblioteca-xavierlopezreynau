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

public class CheckoutMovieOptionTest {
    Printer printer;
    BufferedReader reader;
    Library<Movie> movieLibrary;
    CheckoutMovieOption checkoutMovieOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        movieLibrary = mock(Library.class);
        checkoutMovieOption = new CheckoutMovieOption(printer, reader, movieLibrary);
    }

    @Test
    public void shouldCheckoutSelectedMovie () throws IOException, InvalidItem, SessionException {
        int bookNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(bookNumber));

        checkoutMovieOption.execute();

        verify(movieLibrary).checkoutItem(bookNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(movieLibrary);
    }
}
