package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Printable {
    private List<String> options;

    public Menu() {
        options = new ArrayList<>();
    }

    public List<String> getOptions() {
        return options;
    }

    public void add (String option) {
        options.add(option);
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();
        result.append("Menu:\n");
        int optionNum = 1;
        for (String option : options) {
            result.append(optionNum).append(". ").append(option).append("\n");
        }
        return result.toString();
    }
}
