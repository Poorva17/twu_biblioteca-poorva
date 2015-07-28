package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ListOfBooksTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));

    }

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        ListOfBooks listOfBooks = new ListOfBooks(bookList);
        listOfBooks.addBooks();
        listOfBooks.showList();

        assertEquals("Harry Potter\nHead First Java\n", outputStream.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }
}
