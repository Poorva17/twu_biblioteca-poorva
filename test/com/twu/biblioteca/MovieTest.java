package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void shouldReturnTrueIfTitleMatches() {
        String title = "Krish";
        String yearPublished = "2011";
        String director = "Rakesh Roshan";
        String movieRating = "4";
        Movie movie = new Movie(title, yearPublished, director, movieRating);

        assertEquals(true, movie.hasTitle("Krish"));
    }

    @Test
    public void shouldReturnFalseIfTitleDoesNotMatch() {
        String title = "Krish";
        String yearPublished = "2011";
        String director = "Rakesh Roshan";
        String movieRating = "4";
        Movie movie = new Movie(title, yearPublished, director, movieRating);

        assertEquals(false, movie.hasTitle("Krish 2"));
    }
}
