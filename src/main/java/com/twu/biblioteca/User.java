package com.twu.biblioteca;

public class User implements Printable {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
    }

    public String getHash () {
        return name + ":" + password;
    }

    @Override
    public String serialize() {
        return name;
    }
}
