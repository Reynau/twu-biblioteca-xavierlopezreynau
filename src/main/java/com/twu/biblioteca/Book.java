package com.twu.biblioteca;

public class Book implements Printable {
    private String name;
    private String author;
    private int yearPublished;
    private int rating;

    public Book (String name, String author, int yearPublished, int rating) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.rating = rating;
    }

    public String serialize() {
        String ratingStr = (rating == 0) ? "unrated" : rating + "/10";
        return name + " by " + author + " (" + yearPublished + ") " + ratingStr;
    }
}
