package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldReturnSerializedBook () {
        Book book = new Book("Book1", "Author1", "Year1");

        String serializedBook = book.serialize();

        String expected = "Book1:Author1:Year1";
        assertThat(serializedBook, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = Book.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }
}
