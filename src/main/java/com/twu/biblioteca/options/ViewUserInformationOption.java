package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

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
            printer.print(Constants.ERROR_NOT_LOGGED_IN);
            return;
        }

        printer.print(user.getData());
    }
}
