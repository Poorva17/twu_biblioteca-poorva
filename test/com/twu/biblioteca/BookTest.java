package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void shouldReturnTrueIfBookIsAvailable() {
        String name = "Computer Networks";
        String author = "Taneunbaum";
        String year = "2008";
        boolean isAvailable = true;
        Book book = new Book(name, author, year, isAvailable);

        assertEquals(true, book.ckeckout());
    }

    @Test
    public void shouldReturnValidBook() {
        String name = "Computer Networks";
        String author = "Taneunbaum";
        String year = "2008";
        boolean isAvailable = false;
        Book book = new Book(name, author, year, isAvailable);

        assertEquals(true, book.ckeckin());
    }
}
