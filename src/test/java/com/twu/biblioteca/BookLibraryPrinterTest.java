package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookLibraryPrinterTest {
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
    public void shouldPrintBooksList () {
        // given
        PrintStream printStream = mock(PrintStream.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.getBooks()).thenReturn(books);

        BookLibraryPrinter bookLibraryPrinter = new BookLibraryPrinter(printStream, bookLibrary);

        //then
        bookLibraryPrinter.printBooks();

        //should
        verify(printStream).println(books.get(0));
        verify(printStream).println(books.get(1));
        verify(printStream).println(books.get(2));
        verifyNoMoreInteractions(printStream);
    }
}