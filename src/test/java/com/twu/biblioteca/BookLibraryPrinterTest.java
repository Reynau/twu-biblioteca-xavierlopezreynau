package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class BookLibraryPrinterTest {

    @Test
    public void shouldPrintBooksList () {
        // given
        PrintStream printStream = mock(PrintStream.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.getBooks()).thenReturn(Arrays.asList("Book1", "Book2", "Book3"));

        BookLibraryPrinter bookLibraryPrinter = new BookLibraryPrinter(printStream, bookLibrary);

        //then
        bookLibraryPrinter.printBooks();

        //should
        verify(printStream).println("Book1");
        verify(printStream).println("Book2");
        verify(printStream).println("Book3");
        verifyNoMoreInteractions(printStream);
    }
}
