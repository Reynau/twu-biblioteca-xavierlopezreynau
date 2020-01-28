package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.io.IOException;

public class ReturnMovieOption extends Option {
    private static final String TITLE = "Return a movie";

    Reader reader;
    Printer printer;
    Library<Movie> movieLibrary;

    public ReturnMovieOption(Printer printer, Reader reader, Library<Movie> movieLibrary) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void execute() {
        try {
            int optionNumber = reader.readInt();
            movieLibrary.returnItem(optionNumber, UserRepository.userRepository.getLoggedUser());
        }
        catch (IOException | InvalidItem | SessionException e) {
            printer.print(e.getMessage());
        }
    }
}
