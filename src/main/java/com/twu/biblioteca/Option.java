package com.twu.biblioteca;

public abstract class Option {
    private String title;

    public Option(String title) {
        this.title = title;
    }

    public String serialize () {
        return title;
    }

    public abstract void execute();
}
