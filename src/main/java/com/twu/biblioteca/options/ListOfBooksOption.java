package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

public class ListOfBooksOption extends Option {
    private static final String TITLE = "List of books";

    private Library<Book> bookLibrary;
    private Printer printer;

    public ListOfBooksOption(Library<Book> bookLibrary, Printer printer) {
        super(TITLE);

        this.bookLibrary = bookLibrary;
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.print(bookLibrary);
    }
}
