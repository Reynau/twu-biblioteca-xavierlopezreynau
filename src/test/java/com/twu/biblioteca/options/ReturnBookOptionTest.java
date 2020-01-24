package com.twu.biblioteca.options;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.exceptions.InvalidBook;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ReturnBookOptionTest {
    Printer printer;
    BufferedReader reader;
    BookLibrary bookLibrary;
    ReturnBookOption returnBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        bookLibrary = mock(BookLibrary.class);
        returnBookOption = new ReturnBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidBook {
        int bookNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(bookNumber));

        returnBookOption.execute();

        verify(bookLibrary).returnBook(bookNumber);
        verifyNoMoreInteractions(bookLibrary);
    }
}
