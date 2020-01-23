package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Printable {
    private List<Option> options;

    public Menu() {
        options = new ArrayList<>();
    }

    public List<Option> getOptions() {
        return options;
    }

    public void add (Option option) {
        options.add(option);
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();
        result.append("Menu:\n");
        int optionNum = 1;
        for (Option option : options) {
            result.append(optionNum).append(". ").append(option.serialize()).append("\n");
        }
        return result.toString();
    }
}
