package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

public class ListOfMoviesOption extends Option {
    private static final String TITLE = "List of movies";

    private Library<Movie> movieLibrary;
    private Printer printer;

    public ListOfMoviesOption(Library<Movie> movieLibrary, Printer printer) {
        super(TITLE);

        this.movieLibrary = movieLibrary;
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.print(movieLibrary);
    }
}
