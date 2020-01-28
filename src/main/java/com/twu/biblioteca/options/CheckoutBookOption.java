package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.io.IOException;

public class CheckoutBookOption extends Option {
    private static final String TITLE = "Check-out book";

    Reader reader;
    Printer printer;
    Library<Book> bookLibrary;

    public CheckoutBookOption(Printer printer, Reader reader, Library<Book> bookLibrary) {
        super(TITLE);

        this.reader = reader;
        this.printer = printer;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute() {
        try {
            int optionNumber = reader.readInt();
            bookLibrary.checkoutItem(optionNumber, UserRepository.userRepository.getLoggedUser());
        }
        catch (InvalidItem | SessionException | IOException e) {
            printer.print(e.getMessage());
        }
    }
}
