package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

public class BookLibraryTest {

    @Test
    public void shouldReturnBookList () {
        //given
        List<String> actualList = Arrays.asList("Book1", "Book2", "Book3");
        BookLibrary bookLibrary = new BookLibrary(actualList);

        //then
        List<String> bookList = bookLibrary.getBooks();

        //should
        List<String> expectedList = Arrays.asList("Book1", "Book2", "Book3");
        assertThat(bookList, is(expectedList));
    }
}
