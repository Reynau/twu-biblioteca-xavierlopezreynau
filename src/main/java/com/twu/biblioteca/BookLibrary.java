package com.twu.biblioteca;

import java.util.List;

public class BookLibrary {
    private List<Book> books;

    public BookLibrary (List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
