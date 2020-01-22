package com.twu.biblioteca;

import java.io.PrintStream;

public class WelcomePrinter {
    private PrintStream printStream;

    static final String WELCOMNE_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public WelcomePrinter (PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcome () {
        printStream.println(WELCOMNE_MESSAGE);
    }
}
