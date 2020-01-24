package com.twu.biblioteca;

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
