package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldReturnSerializedBook () {
        Book book = new Book("Book1", "Author1", "Year1");

        String serializedBook = book.toString();

        String expected = "Book1:Author1:Year1";
        assertThat(serializedBook, is(expected));
    }
}
