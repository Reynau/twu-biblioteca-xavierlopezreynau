package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> menuOptions;

    public Menu() {
        menuOptions = new ArrayList<>();
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void add (String option) {
        menuOptions.add(option);
    }
}
