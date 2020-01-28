package com.twu.biblioteca.options;

import com.twu.biblioteca.Constants;
import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;

public class LogInOption extends Option {
    private static final String TITLE = "Log In";

    private BufferedReader reader;
    private Printer printer;

    public LogInOption(Printer printer, BufferedReader reader) {
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
            username = reader.readLine();
        }
        catch (IOException e) {
            printer.print(Constants.ERROR_READING_INPUT);
        }

        printer.print(Constants.INSERT_PASSWORD);
        try {
            password = reader.readLine();
        }
        catch (IOException e) {
            printer.print(Constants.ERROR_READING_INPUT);
        }

        return username + ":" + password;
    }
}
