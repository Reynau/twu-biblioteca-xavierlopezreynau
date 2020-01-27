package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PrinterTest {
    private PrintStream printStream;
    private Printer printer;

    @Before
    public void setUp () {
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
    }

    @Test
    public void shouldPrintTheString () {
        String testString = "Hello world!";

        printer.print(testString);

        verify(printStream).println(testString);
    }

    @Test
    public void shouldPrintThePrintableObject () {
        String expected = "Hey! I'm a serialized book library!";
        Library<Book> bookLibrary = mock(Library.class);
        when(bookLibrary.serialize()).thenReturn(expected);

        printer.print(bookLibrary);

        verify(printStream).println(expected);
    }
}
