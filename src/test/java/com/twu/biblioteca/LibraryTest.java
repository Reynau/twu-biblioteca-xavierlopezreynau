package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;
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
    private User user;

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

        user = mock(User.class);
        when(user.getHash()).thenReturn("u1:p1");

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
    public void shouldStoreCheckedOutStateOfBooks () throws InvalidItem, SessionException {
        bookLibrary.checkoutItem(1, user);

        String actual = bookLibrary.serialize();
        String expected = "2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsCheckedOut () throws InvalidItem, SessionException {
        bookLibrary.checkoutItem(3, user);

        verify(printer).print(Constants.SUCCESS_CHECKOUT_MESSAGE);
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldPrintUnSuccessfulMessageWhenBookIsCheckedOut () throws InvalidItem, SessionException {
        bookLibrary.checkoutItem(3, user);
        bookLibrary.checkoutItem(3, user);

        verify(printer).print(Constants.ERROR_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldStoreReturnedBookState () throws InvalidItem, SessionException {
        bookLibrary.checkoutItem(1, user);
        bookLibrary.returnItem(1, user);

        String actual = bookLibrary.serialize();
        String expected = "1. Book1:Author1:Year1\n2. Book2:Author2:Year2\n3. Book3:Author3:Year3\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldPrintSuccessfulMessageWhenBookIsReturned () throws InvalidItem, SessionException {
        bookLibrary.checkoutItem(3, user);
        bookLibrary.returnItem(3, user);

        verify(printer).print(Constants.SUCCESS_RETURN_MESSAGE);
    }

    @Test(expected=InvalidItem.class)
    public void shouldPrintUnSuccessfulMessageWhenBookIsReturned () throws InvalidItem, SessionException {
        bookLibrary.returnItem(3, user);

        verify(printer).print(Constants.ERROR_RETURN_MESSAGE);
    }
}
