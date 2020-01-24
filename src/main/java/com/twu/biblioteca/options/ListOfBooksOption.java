package com.twu.biblioteca.options;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;

public class ListOfBooksOption extends Option {
    private static final String TITLE = "List of books";

    private BookLibrary bookLibrary;
    private Printer printer;

    public ListOfBooksOption(BookLibrary bookLibrary, Printer printer) {
        super(TITLE);

        this.bookLibrary = bookLibrary;
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.print(bookLibrary);
    }
}
