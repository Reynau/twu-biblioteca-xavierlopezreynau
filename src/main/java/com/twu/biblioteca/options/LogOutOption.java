package com.twu.biblioteca.options;

import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.UserRepository;

public class LogOutOption extends Option {
    private static final String TITLE = "Log Out";

    private Printer printer;

    public LogOutOption(Printer printer) {
        super(TITLE);

        this.printer = printer;
    }

    @Override
    public void execute() {
        if (UserRepository.userRepository.getLoggedUser() == null) {
            printer.print("You are not logged in!");
            return;
        }

        UserRepository.userRepository.logOut();
        printer.print("Logged out successfully!");
    }
}
