package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.MenuException;

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

    public void select (int optionNumber) throws MenuException {
        if (optionNumber < 0 || optionNumber > options.size()) { throw new MenuException(Constants.ERROR_INVALID_OPTION); }
        Option option = options.get(optionNumber);
        option.execute();
    }

    public String serialize () {
        StringBuilder result = new StringBuilder();
        result.append("Menu:\n");
        int optionNum = 0;
        for (Option option : options) {
            result.append(optionNum).append(".\t").append(option.serialize()).append("\n");
            ++optionNum;
        }
        return result.toString();
    }
}
