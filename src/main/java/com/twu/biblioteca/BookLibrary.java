package com.twu.biblioteca;

import java.util.List;

public class BookLibrary {
    private List<String> books;

    public BookLibrary (List<String> books) {
        this.books = books;
    }

    public List<String> getBooks() {
        return books;
    }
}
