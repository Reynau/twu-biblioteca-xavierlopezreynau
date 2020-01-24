package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookLibrary implements Printable {
    private List<Book> books;
    private List<Boolean> checkedOut;

    public BookLibrary (List<Book> books) {
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
        this.checkedOut.set(bookNumber-1, Boolean.TRUE);
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < books.size(); ++i){
            if (checkedOut.get(i)) continue;

            Book book = books.get(i);
            result.append(book.serialize());
            result.append("\n");
        }
        return result.toString();
    }
}
