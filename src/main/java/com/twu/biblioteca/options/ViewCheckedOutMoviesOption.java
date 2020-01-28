package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

public class ViewCheckedOutMoviesOption extends Option {
    private static final String TITLE = "View check-out movies";

    private Printer printer;
    private Library<Movie> movieLibrary;

    public ViewCheckedOutMoviesOption(Printer printer, Library<Movie> movieLibrary) {
        super(TITLE);

        this.printer = printer;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void execute() {
        printer.print(movieLibrary.getCheckedOutItems());
    }
}
