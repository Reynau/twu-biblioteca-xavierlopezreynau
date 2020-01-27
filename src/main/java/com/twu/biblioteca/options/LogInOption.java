package com.twu.biblioteca.options;

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
            printer.print("Logged in successfully!");
            return;
        }
        printer.print("Incorrect username or password");
    }

    private String requestLogIn() {
        String username = null;
        String password = null;

        printer.print("Insert username:");
        try {
            username = reader.readLine();
        }
        catch (IOException e) {
            printer.print("Error reading input. Please try again.");
        }

        printer.print("Insert password:");
        try {
            password = reader.readLine();
        }
        catch (IOException e) {
            printer.print("Error reading input. Please try again.");
        }

        return username + ":" + password;
    }
}
