package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class MenuTest {

    @Test
    public void shouldAddNewMenuOptions () {
        Menu menu = new Menu();
        List<String> menuOptions;

        menuOptions = menu.getMenuOptions();
        assertThat(0, is(menuOptions.size()));

        menu.add("List of books");
        menuOptions = menu.getMenuOptions();
        assertThat(1, is(menuOptions.size()));
    }

    @Test
    public void shouldGetMenuOptions () {
        Menu menu = new Menu();
        String option = "List of books";

        menu.add(option);

        List<String> menuOptions = menu.getMenuOptions();
        assertThat(option, is(menuOptions.get(0)));
    }
}
