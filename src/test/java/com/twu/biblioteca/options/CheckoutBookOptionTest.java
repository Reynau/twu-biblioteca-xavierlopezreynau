package com.twu.biblioteca.options;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.exceptions.InvalidBook;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class CheckoutBookOptionTest {
    Printer printer;
    BufferedReader reader;
    BookLibrary bookLibrary;
    CheckoutBookOption checkoutBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        bookLibrary = mock(BookLibrary.class);
        checkoutBookOption = new CheckoutBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidBook {
        int bookNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(bookNumber));

        checkoutBookOption.execute();

        verify(bookLibrary).checkoutBook(bookNumber);
        verifyNoMoreInteractions(bookLibrary);
    }
}
