package com.twu.biblioteca.options;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.exceptions.InvalidItem;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ReturnBookOptionTest {
    Printer printer;
    BufferedReader reader;
    Library<Book> bookLibrary;
    ReturnBookOption returnBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        bookLibrary = mock(Library.class);
        returnBookOption = new ReturnBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidItem {
        int bookNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(bookNumber));

        returnBookOption.execute();

        verify(bookLibrary).returnItem(bookNumber);
        verifyNoMoreInteractions(bookLibrary);
    }
}
