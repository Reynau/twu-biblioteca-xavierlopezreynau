package com.twu.biblioteca.options;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListOfBooksOptionTest {
    private Printer printer;
    private BookLibrary bookLibrary;
    private ListOfBooksOption listOfBooksOption;
    @Before
    public void setUp () {
        printer = mock(Printer.class);
        bookLibrary = mock(BookLibrary.class);
        listOfBooksOption = new ListOfBooksOption(bookLibrary, printer);
    }

    @Test
    public void shouldPrintListOfBooksWhenExecuted () {
        listOfBooksOption.execute();

        verify(printer).print(bookLibrary);
        verifyNoMoreInteractions(printer);
    }
}
