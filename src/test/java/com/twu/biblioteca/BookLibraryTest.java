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
    public void shouldReturnBookList () {
        //given
        BookLibrary bookLibrary = new BookLibrary(books);

        //then
        List<Book> bookList = bookLibrary.getBooks();

        //should
        assertThat(bookList, is(books));
    }
}
