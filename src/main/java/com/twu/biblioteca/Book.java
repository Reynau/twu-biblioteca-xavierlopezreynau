package com.twu.biblioteca;

public class Book implements Printable {
    private String name;
    private String author;
    private String yearPublished;

    public Book (String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String serialize() {
        return name + ":" + author + ":" + yearPublished;
    }
}
