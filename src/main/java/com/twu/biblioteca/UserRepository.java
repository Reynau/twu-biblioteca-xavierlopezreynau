package com.twu.biblioteca;

import java.util.HashMap;

public class UserRepository {

    HashMap<String, User> users;
    User loggedUser;

    public static UserRepository userRepository = new UserRepository();

    private UserRepository() {
        users = new HashMap<>();

        for (User user : Data.users) {
            users.put(user.getHash(), user);
        }

        loggedUser = null;
    }

    public User getLoggedUser () {
        return loggedUser;
    }

    public boolean logIn(String credentials) {
        loggedUser = users.get(credentials);
        return loggedUser != null;
    }

    public void logOut () {
        loggedUser = null;
    }
}
