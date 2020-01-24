package com.twu.biblioteca;

public class ExitOption extends Option {
    private static final String TITLE = "Close the application";

    public ExitOption() {
        super(TITLE);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
