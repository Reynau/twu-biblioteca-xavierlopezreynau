package com.twu.biblioteca;

public class User implements Printable {

    private String name;
    private String password;
    private String email;
    private int phone;

    public User(String name, String password, String email, int phone) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getHash () {
        return name + ":" + password;
    }

    @Override
    public String serialize() {
        return name;
    }

    public String getData () {
        return name + " - " + email + " - " + phone;
    }
}
