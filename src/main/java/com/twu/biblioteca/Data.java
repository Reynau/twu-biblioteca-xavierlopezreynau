package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static final List<Book> bookList = Arrays.asList(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 1965, 8),
            new Book("In search of the lost time", "Marcel Proust", 1913, 6),
            new Book("Ulysses", "James Joyce", 1904, 0),
            new Book("Moby Dick", "Herman Melville", 1851, 9)
    );

    public static final List<Movie> movieList = Arrays.asList(
            new Movie("The seven samurai", 1954, "Akira Kurosawa", 10),
            new Movie("Bonnie and Clyde", 1967, "Arthur Penn", 8),
            new Movie("Reservoir Dogs", 1992, "Quentin Tarantino", 9),
            new Movie("Airplane!", 1980, "Jim Abrahams, David Zucker, Jerry Zucker", 0),
            new Movie("Pan's Labyrinth", 2006, "Guillermo del Toro", 10),
            new Movie("Doctor Zhivago", 1965, "David Lean", 10)
    );

    public static final List<User> users = Arrays.asList(
            new User("111-1111", "111", "Fahad Shepard", "fahad@email.com", 12345678),
            new User("222-2222", "222", "Nuala Mahoney", "nuala@email.com", 12345678),
            new User("333-3333", "333", "Patrick Atikson", "patrick@email.com", 12345678),
            new User("444-4444", "444", "Franklin Driscoll", "franklin@email.com", 12345678),
            new User("555-5555", "555", "Penny Berger", "penny@email.com", 12345678)
    );
}
