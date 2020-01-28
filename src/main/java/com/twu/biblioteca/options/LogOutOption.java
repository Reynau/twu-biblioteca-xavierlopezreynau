package com.twu.biblioteca.options;

import com.twu.biblioteca.Constants;
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
            printer.print(Constants.ERROR_NOT_LOGGED_IN);
            return;
        }

        UserRepository.userRepository.logOut();
        printer.print(Constants.SUCCESS_LOGOUT);
    }
}
