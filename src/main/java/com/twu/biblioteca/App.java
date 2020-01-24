/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.MenuException;
import com.twu.biblioteca.options.CheckoutBookOption;
import com.twu.biblioteca.options.ExitOption;
import com.twu.biblioteca.options.ListOfBooksOption;
import com.twu.biblioteca.options.ReturnBookOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    static private BufferedReader reader;
    static private Printer printer;

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        printer = new Printer(System.out);

        List<Book> books = createFakeListOfBooks();
        BookLibrary bookLibrary = new BookLibrary(printer, books);

        Menu menu = new Menu();

        Option exitOption = new ExitOption();
        Option listOfBooks = new ListOfBooksOption(bookLibrary, printer);
        Option checkoutBookOption = new CheckoutBookOption(printer, reader, bookLibrary);
        Option returnBookOption = new ReturnBookOption(printer, reader, bookLibrary);

        menu.add(exitOption);
        menu.add(listOfBooks);
        menu.add(checkoutBookOption);
        menu.add(returnBookOption);

        printer.print(WELCOME_MESSAGE);

        int optionNumber;
        do {
            printer.print(menu);
            optionNumber = requestAction();
            try {
                menu.select(optionNumber);
            }
            catch (MenuException e) {
                printer.print(e.getMessage());
            }
        }
        while (optionNumber != 0);
    }

    private static int requestAction() {
        String input = null;
        int optionNumber;

        try {
            input = reader.readLine();
        }
        catch (IOException e) {
            printer.print("Error reading output:\n".concat(e.getMessage()));
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

    private static List<Book> createFakeListOfBooks () {
        List<Book> books = new ArrayList<>();
        for (int i=1; i < 4; ++i) {
            String name = "Book" + i;
            String author = "Author" + i;
            String yearPublished = "Year" + i;

            Book book = new Book(name, author, yearPublished);

            books.add(book);
        }
        return books;
    }
}
/*
BookLibrary contains Printer
Interactions should be on BookLibrary instead of BookLibraryPrinter
*/
