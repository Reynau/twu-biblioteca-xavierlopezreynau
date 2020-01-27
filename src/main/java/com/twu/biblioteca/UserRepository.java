package com.twu.biblioteca;

import java.util.HashMap;

public class UserRepository {

    HashMap<String, User> users;
    User loggedUser;

    public UserRepository() {
        users = new HashMap<>();
        for (int i = 0; i < 5; ++i) {
            users.put("u"+i+":p"+i, new User("u"+i));
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
