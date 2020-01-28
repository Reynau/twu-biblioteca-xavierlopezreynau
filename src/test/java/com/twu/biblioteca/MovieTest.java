package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void shouldReturnSerializedBook () {
        Movie movie = new Movie("Book1", 1900, "Director1", 8);

        String serializedMovie = movie.serialize();

        String expected = "Book1 by Director1 (1900) 8/10";
        assertThat(serializedMovie, is(expected));
    }

    @Test
    public void shouldBePrintable () {
        Class<?> classObj = Movie.class;

        assertThat(Printable.class.isAssignableFrom(classObj), is(true)); // checks if implements printable
    }

    @Test
    public void shouldReturnUnratedWhenNotRated () {
        Movie movie = new Movie("Book1", 1900, "Director1", 0);

        String serializedMovie = movie.serialize();

        String expected = "Book1 by Director1 (1900) unrated";
        assertThat(serializedMovie, is(expected));
    }
}
