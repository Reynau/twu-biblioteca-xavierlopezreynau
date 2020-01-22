package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BookLibraryPrinter {
    private PrintStream printStream;
    private BookLibrary bookLibrary;

    public BookLibraryPrinter (PrintStream printStream, BookLibrary bookLibrary) {
        this.printStream = printStream;
        this.bookLibrary = bookLibrary;
    }

    public void printBooks () {
        List<String> books = bookLibrary.getBooks();
        for (String book : books) {
            printStream.println(book);
        }
    }
}
