package com.twu.biblioteca.options;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.exceptions.InvalidBook;

import java.io.BufferedReader;
import java.io.IOException;

public class ReturnBookOption extends Option {
    private static final String TITLE = "Return a book";

    BufferedReader reader;
    Printer printer;
    BookLibrary bookLibrary;

    public ReturnBookOption(Printer printer, BufferedReader reader, BookLibrary bookLibrary) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute() {
        int optionNumber = requestBookNumber();

        try {
            bookLibrary.returnBook(optionNumber);
        }
        catch (InvalidBook e) {
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
            printer.print("Error reading input. Please try again.");
        }

        try {
            optionNumber = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            printer.print("Invalid option. Please try again.");
            return -1;
        }
        return optionNumber;
    }
}
