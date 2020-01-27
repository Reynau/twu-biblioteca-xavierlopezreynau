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

public class CheckoutBookOptionTest {
    Printer printer;
    BufferedReader reader;
    Library<Book> bookLibrary;
    CheckoutBookOption checkoutBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(BufferedReader.class);
        bookLibrary = mock(Library.class);
        checkoutBookOption = new CheckoutBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidItem {
        int bookNumber = 1;
        when(reader.readLine()).thenReturn(Integer.toString(bookNumber));

        checkoutBookOption.execute();

        verify(bookLibrary).checkoutItem(bookNumber);
        verifyNoMoreInteractions(bookLibrary);
    }
}
