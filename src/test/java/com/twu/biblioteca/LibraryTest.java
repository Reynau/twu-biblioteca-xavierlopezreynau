package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    private Printer printer;
    private List<Book> books;

    Library<Book> bookLibrary;

    @Before
    public void setUp () {
        printer = mock(Printer.class);

        books = new ArrayList<>();
        for (int i=1; i < 4; ++i) {
            Book book = mock(Book.class);
            when(book.serialize()).thenReturn("Book"+i+":Author"+i+":Year"+i);
            books.add(book);
        }

        bookLibrary = new Library<>(printer, books);
    }

    @Test
    public void shouldReturnSerializedBookLibrary () {
        String expected = "1. Book1:Author1:Year1\n2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";
        String actual = bookLibrary.serialize();

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = Library.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }

    @Test
    public void shouldStoreCheckedOutStateOfBooks () throws InvalidItem {
        bookLibrary.checkoutItem(1);

        String actual = bookLibrary.serialize();
        String expected = "2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsCheckedOut () throws InvalidItem {
        bookLibrary.checkoutItem(3);

        verify(printer).print("Thank you! Enjoy the item");
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldPrintUnSuccessfulMessageWhenBookIsCheckedOut () throws InvalidItem {
        bookLibrary.checkoutItem(3);
        bookLibrary.checkoutItem(3);

        verify(printer).print("Sorry, that item is not available");
    }

    @Test
    public void shouldStoreReturnedBookState () throws InvalidItem {
        bookLibrary.checkoutItem(1);
        bookLibrary.returnItem(1);

        String actual = bookLibrary.serialize();
        String expected = "1. Book1:Author1:Year1\n2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessfulMessageWhenBookIsReturned () throws InvalidItem {
        bookLibrary.checkoutItem(3);
        bookLibrary.returnItem(3);

        verify(printer).print("Thank you for returning the item");
    }

    @Test
    public void shouldPrintUnSuccessfulMessageWhenBookIsReturned () throws InvalidItem {
        bookLibrary.returnItem(3);

        verify(printer).print("That is not a valid item to return");
    }
}
