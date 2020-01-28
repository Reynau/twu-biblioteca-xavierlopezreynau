package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ReturnBookOptionTest {
    Printer printer;
    Reader reader;
    Library<Book> bookLibrary;
    ReturnBookOption returnBookOption;

    @Before
    public void setUp () {
        printer = mock(Printer.class);
        reader = mock(Reader.class);
        bookLibrary = mock(Library.class);
        returnBookOption = new ReturnBookOption(printer, reader, bookLibrary);
    }

    @Test
    public void shouldCheckoutSelectedBook () throws IOException, InvalidItem, SessionException {
        int bookNumber = 1;
        when(reader.readInt()).thenReturn(bookNumber);

        returnBookOption.execute();

        verify(bookLibrary).returnItem(bookNumber, UserRepository.userRepository.getLoggedUser());
        verifyNoMoreInteractions(bookLibrary);
    }
}
