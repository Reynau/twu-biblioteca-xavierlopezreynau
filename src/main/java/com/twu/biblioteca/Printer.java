package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {
    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print (String str) {
        printStream.println(str);
    }

    public void print (Printable item) {
        String serializedItem = item.serialize();
        printStream.println(serializedItem);
    }
}
