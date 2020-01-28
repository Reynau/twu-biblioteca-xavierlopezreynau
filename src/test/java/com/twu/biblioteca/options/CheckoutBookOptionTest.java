package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CheckoutBookOptionTest {
    Printer printer;
    Reader reader;
    Library<Book> bookLibrary;
    CheckoutBookOption checkoutBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(Reader.class);
        bookLibrary = mock(Library.class);
        checkoutBookOption = new CheckoutBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidItem, SessionException {
        int bookNumber = 1;
        when(reader.readInt()).thenReturn(bookNumber);

        checkoutBookOption.execute();

        verify(bookLibrary).checkoutItem(bookNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(bookLibrary);
    }
}
