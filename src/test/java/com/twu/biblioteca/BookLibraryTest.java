package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibraryTest {
    public List<Book> books;

    @Before
    public void setUp () {
        books = new ArrayList<>();
        for (int i=1; i < 4; ++i) {
            String name = "Book" + i;
            String author = "Author" + i;
            String yearPublished = "Year" + i;

            Book book = new Book(name, author, yearPublished);

            books.add(book);
        }
    }

    @Test
    public void shouldReturnSerializedBookLibrary () {
        BookLibrary bookLibrary = new BookLibrary(books);

        String expected = "Book1:Author1:Year1\nBook2:Author2:Year2\nBook3:Author3:Year3\n";
        String actual = bookLibrary.serialize();

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = BookLibrary.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }
}
