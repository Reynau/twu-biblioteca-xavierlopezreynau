package com.twu.biblioteca.options;

import com.twu.biblioteca.*;
import com.twu.biblioteca.exceptions.InvalidItem;

import java.io.BufferedReader;
import java.io.IOException;

public class ReturnMovieOption extends Option {
    private static final String TITLE = "Return a movie";

    BufferedReader reader;
    Printer printer;
    Library<Movie> movieLibrary;

    public ReturnMovieOption(Printer printer, BufferedReader reader, Library<Movie> movieLibrary) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void execute() {
        int optionNumber = requestMovieNumber();

        try {
            movieLibrary.returnItem(optionNumber);
        }
        catch (InvalidItem e) {
            printer.print(e.getMessage());
        }
    }

    private int requestMovieNumber() {
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
