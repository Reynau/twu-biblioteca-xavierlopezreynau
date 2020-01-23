package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp () {
        menu = new Menu();
    }

    @Test
    public void shouldAddNewMenuOptions () {
        List<String> menuOptions;

        menuOptions = menu.getMenuOptions();
        assertThat(0, is(menuOptions.size()));

        menu.add("List of books");
        menuOptions = menu.getMenuOptions();
        assertThat(1, is(menuOptions.size()));
    }

    @Test
    public void shouldGetMenuOptions () {
        String option = "List of books";

        menu.add(option);

        List<String> menuOptions = menu.getMenuOptions();
        assertThat(option, is(menuOptions.get(0)));
    }

    @Test
    public void shouldBePrintable () {
        String option = "List of books";

        menu.add(option);

        String expectedStr = "Menu:\n1. List of books\n";
        String actualStr = menu.serialize();
        Class<?> classObj = Menu.class;

        assertThat(actualStr, is(expectedStr));
        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }
}
