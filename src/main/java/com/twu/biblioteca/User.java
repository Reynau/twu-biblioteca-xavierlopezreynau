package com.twu.biblioteca;

public class User implements Printable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String serialize() {
        return name;
    }
}
