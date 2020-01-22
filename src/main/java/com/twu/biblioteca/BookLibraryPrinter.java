package com.twu.biblioteca;

import java.io.PrintStream;

public class BookLibraryPrinter {
    private PrintStream printStream;

    public BookLibraryPrinter (PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printBooks () {
        printStream.println("Book\nBook\nBook\n");
    }
}
