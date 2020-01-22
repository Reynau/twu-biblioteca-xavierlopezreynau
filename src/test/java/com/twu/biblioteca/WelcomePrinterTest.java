package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WelcomePrinterTest {

    @Test
    public void shouldPrintWelcomeMessage () {
        PrintStream printStream = mock(PrintStream.class);
        WelcomePrinter welcomePrinter = new WelcomePrinter(printStream);

        welcomePrinter.printWelcome();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
