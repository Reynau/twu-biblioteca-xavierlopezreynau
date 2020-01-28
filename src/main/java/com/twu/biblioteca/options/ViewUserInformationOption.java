package com.twu.biblioteca.options;

import com.twu.biblioteca.Option;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.User;
import com.twu.biblioteca.UserRepository;

public class ViewUserInformationOption extends Option {
    private static final String TITLE = "View user information";

    private Printer printer;

    public ViewUserInformationOption(Printer printer) {
        super(TITLE);

        this.printer = printer;
    }

    @Override
    public void execute() {
        User user = UserRepository.userRepository.getLoggedUser();
        if (user == null) {
            printer.print("You need to be logged in!");
            return;
        }

        printer.print(user.getData());
    }
}
