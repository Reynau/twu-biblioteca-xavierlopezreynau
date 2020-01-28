package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.io.IOException;

public class ReturnBookOption extends Option {
    private static final String TITLE = "Return a book";

    Reader reader;
    Printer printer;
    Library<Book> bookLibrary;

    public ReturnBookOption(Printer printer, Reader reader, Library<Book> bookLibrary) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute() {
        try {
            int optionNumber = reader.readInt();
            bookLibrary.returnItem(optionNumber, UserRepository.userRepository.getLoggedUser());
        }
        catch (IOException | InvalidItem | SessionException e) {
            printer.print(e.getMessage());
        }
    }
}
