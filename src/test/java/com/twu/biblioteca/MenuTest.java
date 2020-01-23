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

        menuOptions = menu.getOptions();
        assertThat(0, is(menuOptions.size()));

        menu.add("List of books");
        menuOptions = menu.getOptions();
        assertThat(1, is(menuOptions.size()));
    }

    @Test
    public void shouldGetMenuOptions () {
        String option = "List of books";

        menu.add(option);

        List<String> menuOptions = menu.getOptions();
        assertThat(option, is(menuOptions.get(0)));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = Menu.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }

    @Test
    public void shouldSerializeCorrectly () {
        String option = "List of books";

        menu.add(option);

        String expected = "Menu:\n1. List of books\n";
        String actual = menu.serialize();

        assertThat(actual, is(expected));
    }
}
