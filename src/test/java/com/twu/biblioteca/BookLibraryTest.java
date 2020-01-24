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
        String expected = "1. Book1:Author1:Year1\n2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";
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
        bookLibrary.checkoutBook(1);

        String actual = bookLibrary.serialize();
        String expected = "2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

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

    @Test
    public void shouldStoreReturnedBookState () throws InvalidBook {
        bookLibrary.checkoutBook(1);
        bookLibrary.returnBook(1);

        String actual = bookLibrary.serialize();
        String expected = "1. Book1:Author1:Year1\n2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessfulMessageWhenBookIsReturned () throws InvalidBook {
        bookLibrary.checkoutBook(3);
        bookLibrary.returnBook(3);

        verify(printer).print("Thank you for returning the book");
    }

    @Test
    public void shouldPrintUnSuccessfulMessageWhenBookIsReturned () throws InvalidBook {
        bookLibrary.returnBook(3);

        verify(printer).print("That is not a valid book to return");
    }
}
