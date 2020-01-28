package com.twu.biblioteca.options;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ViewCheckedOutBooksOptionTest {
    Printer printer;
    Library<Book> bookLibrary;
    ViewCheckedOutBooksOption viewCheckedOutBooksOption;

    @Before
    public void setUp() throws Exception {
        printer = mock(Printer.class);
        bookLibrary = mock(Library.class);
        viewCheckedOutBooksOption = new ViewCheckedOutBooksOption(printer, bookLibrary);
    }

    @Test
    public void shouldPrintTheListOfCheckedOutBooks () {
        viewCheckedOutBooksOption.execute();
        verify(printer).print(bookLibrary.getCheckedOutItems());
        verifyNoMoreInteractions(printer);
    }
}
