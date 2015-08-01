package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void shouldReturnTrueIfTitleMatches() {
        String name = "Computer Networks";
        String author = "Taneunbaum";
        String year = "2008";
        Book book = new Book(name, author, year);

        assertEquals(true, book.hasTitle("Computer Networks"));
    }

    @Test
    public void shouldReturnFalseIfTitleDoesNotMatch() {
        String name = "Computer Networks";
        String author = "Taneunbaum";
        String year = "2008";
        Book book = new Book(name, author, year);

        assertEquals(false, book.hasTitle("Data Structures"));
    }
}
