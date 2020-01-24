package com.twu.biblioteca.exceptions;

public class InvalidBook extends Exception {
    public InvalidBook(String messageError) {
        super(messageError);
    }
}
