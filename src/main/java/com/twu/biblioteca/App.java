/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.twu.biblioteca;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        WelcomePrinter welcomePrinter = new WelcomePrinter(System.out);
        BookLibrary bookLibrary = new BookLibrary(Arrays.asList("Book1", "Book2", "Book3"));
        BookLibraryPrinter bookLibraryPrinter = new BookLibraryPrinter(System.out, bookLibrary);

        welcomePrinter.printWelcome();
        bookLibraryPrinter.printBooks();
    }
}
