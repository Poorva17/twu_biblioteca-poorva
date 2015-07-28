package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void shouldReturnBookName() {
        Book book = new Book("Head First Java");

        assertEquals("Head First Java", book.getName());
    }
}

