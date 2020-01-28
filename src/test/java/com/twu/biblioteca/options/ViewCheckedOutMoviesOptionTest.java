package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ViewCheckedOutMoviesOptionTest {
    Printer printer;
    Library<Movie> movieLibrary;
    ViewCheckedOutMoviesOption viewCheckedOutMoviesOption;

    @Before
    public void setUp() throws Exception {
        printer = mock(Printer.class);
        movieLibrary = mock(Library.class);
        viewCheckedOutMoviesOption = new ViewCheckedOutMoviesOption(printer, movieLibrary);
    }

    @Test
    public void shouldPrintTheListOfCheckedOutBooks () {
        viewCheckedOutMoviesOption.execute();
        verify(printer).print(movieLibrary.getCheckedOutItems());
        verifyNoMoreInteractions(printer);
    }
}
