package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookLibraryPrinterTest {

    @Test
    public void shouldPrintBooksList () {
        // given
        PrintStream printStream = mock(PrintStream.class);
        BookLibraryPrinter bookLibraryPrinter = new BookLibraryPrinter(printStream);

        //then
        bookLibraryPrinter.printBooks();

        //should
        verify(printStream).println("Book\nBook\nBook\n");
    }
}
