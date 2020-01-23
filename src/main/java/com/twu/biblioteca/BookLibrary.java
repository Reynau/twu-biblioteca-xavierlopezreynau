package com.twu.biblioteca;

import java.util.List;

public class BookLibrary implements Printable {
    private List<Book> books;

    public BookLibrary (List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            result.append(book.serialize());
            result.append("\n");
        }
        return result.toString();
    }
}
