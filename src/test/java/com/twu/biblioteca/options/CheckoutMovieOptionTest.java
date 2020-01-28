package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CheckoutMovieOptionTest {
    Printer printer;
    Reader reader;
    Library<Movie> movieLibrary;
    CheckoutMovieOption checkoutMovieOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(Reader.class);
        movieLibrary = mock(Library.class);
        checkoutMovieOption = new CheckoutMovieOption(printer, reader, movieLibrary);
    }

    @Test
    public void shouldCheckoutSelectedMovie () throws IOException, InvalidItem, SessionException {
        int bookNumber = 1;
        when(reader.readInt()).thenReturn(bookNumber);

        checkoutMovieOption.execute();

        verify(movieLibrary).checkoutItem(bookNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(movieLibrary);
    }
}
