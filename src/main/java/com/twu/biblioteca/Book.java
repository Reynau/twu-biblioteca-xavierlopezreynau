package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String yearPublished;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return name + ":" + author + ":" + yearPublished;
    }
}
