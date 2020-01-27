package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListOfMoviesOptionTest {
    private Printer printer;
    private Library<Movie> movieLibrary;
    private ListOfMoviesOption listOfMoviesOption;
    @Before
    public void setUp () {
        printer = mock(Printer.class);
        movieLibrary = mock(Library.class);
        listOfMoviesOption = new ListOfMoviesOption(movieLibrary, printer);
    }

    @Test
    public void shouldPrintListOfBooksWhenExecuted () {
        listOfMoviesOption.execute();

        verify(printer).print(movieLibrary);
        verifyNoMoreInteractions(printer);
    }
}
