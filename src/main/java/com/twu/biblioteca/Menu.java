package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Printable {
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

    public String serialize () {
        StringBuilder result = new StringBuilder();
        result.append("Menu:\n");
        int optionNum = 1;
        for (String option : menuOptions) {
            result.append(optionNum).append(". ").append(option).append("\n");
        }
        return result.toString();
    }
}
