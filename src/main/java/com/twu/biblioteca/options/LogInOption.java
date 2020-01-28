package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

import java.io.IOException;

public class LogInOption extends Option {
    private static final String TITLE = "Log In";

    private Reader reader;
    private Printer printer;

    public LogInOption(Printer printer, Reader reader) {
        super(TITLE);

        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void execute() {
        String credentials = requestLogIn();
        if (UserRepository.userRepository.logIn(credentials)) {
            printer.print(Constants.SUCCESS_LOGIN);
            return;
        }
        printer.print(Constants.ERROR_INVALID_CREDENTIALS);
    }

    private String requestLogIn() {
        String username = null;
        String password = null;

        printer.print(Constants.INSERT_USERNAME);
        try {
            username = reader.readStr();
        }
        catch (IOException e) {
            printer.print(Constants.ERROR_READING_INPUT);
        }

        printer.print(Constants.INSERT_PASSWORD);
        try {
            password = reader.readStr();
        }
        catch (IOException e) {
            printer.print(Constants.ERROR_READING_INPUT);
        }

        return username + ":" + password;
    }
}
