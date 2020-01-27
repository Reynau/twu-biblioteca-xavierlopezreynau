package com.twu.biblioteca;

public class Movie implements Printable {
    private String name;
    private int yearPublished;
    private String director;
    private int rating;

    public Movie(String name, int yearPublished, String director, int rating) {
        this.name = name;
        this.yearPublished = yearPublished;
        this.director = director;
        this.rating = rating;
    }

    public String serialize() {
        String ratingStr = (rating == 0) ? "Unrated" : Integer.toString(rating);
        return name + ":" + yearPublished + ":" + director + ":" + ratingStr;
    }
}
