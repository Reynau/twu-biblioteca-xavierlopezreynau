package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.io.IOException;

public class CheckoutMovieOption extends Option {
    private static final String TITLE = "Check-out movie";

    Reader reader;
    Printer printer;
    Library<Movie> movieLibrary;

    public CheckoutMovieOption(Printer printer, Reader reader, Library<Movie> movieLibrary) {
        super(TITLE);

        this.reader = reader;
        this.printer = printer;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void execute() {
        try {
            int optionNumber = reader.readInt();
            movieLibrary.checkoutItem(optionNumber, UserRepository.userRepository.getLoggedUser());
        }
        catch (IOException | InvalidItem | SessionException e) {
            printer.print(e.getMessage());
        }
    }
}
