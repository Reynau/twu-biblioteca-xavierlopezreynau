package com.twu.biblioteca.options;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListOfBooksOptionTest {
    private Printer printer;
    private Library<Book> bookLibrary;
    private ListOfBooksOption listOfBooksOption;
    @Before
    public void setUp () {
        printer = mock(Printer.class);
        bookLibrary = mock(Library.class);
        listOfBooksOption = new ListOfBooksOption(bookLibrary, printer);
    }

    @Test
    public void shouldPrintListOfBooksWhenExecuted () {
        listOfBooksOption.execute();

        verify(printer).print(bookLibrary);
        verifyNoMoreInteractions(printer);
    }
}
