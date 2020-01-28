package com.twu.biblioteca.options;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;

public class ViewCheckedOutBooksOption extends Option {
    private static final String TITLE = "View check-out books";

    private Printer printer;
    private Library<Book> bookLibrary;

    public ViewCheckedOutBooksOption(Printer printer, Library<Book> bookLibrary) {
        super(TITLE);

        this.printer = printer;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute() {
        printer.print(bookLibrary.getCheckedOutItems());
    }
}
