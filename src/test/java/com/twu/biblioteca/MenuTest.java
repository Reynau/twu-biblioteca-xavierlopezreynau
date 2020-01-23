package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.MenuException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuTest {
    private Menu menu;
    private Option option;

    @Before
    public void setUp () {
        menu = new Menu();
        option = mock(Option.class);
    }

    @Test
    public void shouldAddNewMenuOptions () {
        List<Option> options;

        options = menu.getOptions();
        assertThat(0, is(options.size()));

        menu.add(option);
        options = menu.getOptions();
        assertThat(1, is(options.size()));
    }

    @Test
    public void shouldGetMenuOptions () {
        menu.add(option);

        List<Option> menuOptions = menu.getOptions();
        assertThat(menuOptions, is(Collections.singletonList(option)));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = Menu.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }

    @Test
    public void shouldReturnSerializedMenu () {
        String optionTitle = "List of books";
        when(option.serialize()).thenReturn(optionTitle);

        menu.add(option);

        String expected = "Menu:\n1. List of books\n";
        String actual = menu.serialize();

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldBeSelectable () throws MenuException {
        menu.add(option);

        int optionNum = 1;
        menu.select(optionNum);

        verify(option).execute();
    }

    @Test(expected = MenuException.class)
    public void shouldThrowMenuExceptionOnInvalidOption () throws MenuException {
        int optionNum = 1;
        menu.select(optionNum);
    }
}
