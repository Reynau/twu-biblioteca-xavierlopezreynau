package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidBook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class BookLibraryTest {
    private Printer printer;
    private List<Book> books;

    BookLibrary bookLibrary;

    @Before
    public void setUp () {
        printer = mock(Printer.class);

        books = new ArrayList<>();
        for (int i=1; i < 4; ++i) {
            String name = "Book" + i;
            String author = "Author" + i;
            String yearPublished = "Year" + i;

            Book book = new Book(name, author, yearPublished);

            books.add(book);
        }

        bookLibrary = new BookLibrary(printer, books);
    }

    @Test
    public void shouldReturnSerializedBookLibrary () {
        String expected = "Book1:Author1:Year1\nBook2:Author2:Year2\nBook3:Author3:Year3\n";
        String actual = bookLibrary.serialize();

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = BookLibrary.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }

    @Test
    public void shouldStoreCheckedOutStateOfBooks () throws InvalidBook {
        bookLibrary.checkoutBook(3);

        String actual = bookLibrary.serialize();
        String expected = "Book1:Author1:Year1\nBook2:Author2:Year2\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsCheckedOut () throws InvalidBook {
        bookLibrary.checkoutBook(3);

        verify(printer).print("Thank you! Enjoy the book");
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldPrintUnSuccessfulMessageWhenBookIsCheckedOut () throws InvalidBook {
        bookLibrary.checkoutBook(3);
        bookLibrary.checkoutBook(3);

        verify(printer).print("Sorry, that book is not available");
    }
}
