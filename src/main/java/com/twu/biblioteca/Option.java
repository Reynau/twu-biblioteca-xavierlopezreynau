package com.twu.biblioteca;

public class Option {
    private String title;

    public Option(String title) {
        this.title = title;
    }

    public String serialize () {
        return title;
    }
}
