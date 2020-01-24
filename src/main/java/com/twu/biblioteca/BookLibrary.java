package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookLibrary implements Printable {
    private Printer printer;
    private List<Book> books;
    private List<Boolean> checkedOut;

    public BookLibrary (Printer printer, List<Book> books) {
        this.printer = printer;
        this.books = books;
        this.checkedOut = Arrays.asList(new Boolean[books.size()]);
        Collections.fill(checkedOut, Boolean.FALSE);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void checkoutBook (int bookNumber) throws InvalidBook {
        if (bookNumber < 1 || bookNumber > this.checkedOut.size()) {
            throw new InvalidBook("Invalid book number");
        }

        int bookIndex = bookNumber-1;

        if (this.checkedOut.get(bookIndex)) {
            printer.print("Sorry, that book is not available");
            return;
        }

        this.checkedOut.set(bookIndex, Boolean.TRUE);
        printer.print("Thank you! Enjoy the book");
    }

    public void returnBook (int bookNumber) throws InvalidBook {
        if (bookNumber < 1 || bookNumber > this.checkedOut.size()) {
            throw new InvalidBook("Invalid book number");
        }

        int bookIndex = bookNumber-1;
/*
        if (this.checkedOut.get(bookIndex)) {
            printer.print("Sorry, that book is not available");
            return;
        }
*/
        this.checkedOut.set(bookIndex, Boolean.FALSE);
        //printer.print("Thank you! Enjoy the book");
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < books.size(); ++i){
            if (checkedOut.get(i)) continue;

            Book book = books.get(i);
            result.append(i+1).append(". ").append(book.serialize()).append("\n");
        }
        return result.toString();
    }
}
