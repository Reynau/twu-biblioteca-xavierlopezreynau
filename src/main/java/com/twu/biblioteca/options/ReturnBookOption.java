package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.io.BufferedReader;
import java.io.IOException;

public class ReturnBookOption extends Option {
    private static final String TITLE = "Return a book";

    BufferedReader reader;
    Printer printer;
    Library<Book> bookLibrary;

    public ReturnBookOption(Printer printer, BufferedReader reader, Library<Book> bookLibrary) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute() {
        int optionNumber = requestBookNumber();

        try {
            bookLibrary.returnItem(optionNumber, UserRepository.userRepository.getLoggedUser());
        }
        catch (InvalidItem | SessionException e) {
            printer.print(e.getMessage());
        }
    }

    private int requestBookNumber() {
        String input = null;
        int optionNumber;

        try {
            input = reader.readLine();
        }
        catch (IOException e) {
            printer.print(Constants.ERROR_READING_INPUT);
        }

        try {
            optionNumber = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            printer.print(Constants.ERROR_INVALID_OPTION);
            return -1;
        }
        return optionNumber;
    }
}
