package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }

    @Test
    public void shouldPrintCorrectWelcomeMessage() {
        View view = new View();

        view.printWelcomeMessage();

        assertEquals("Welcome to Biblioteca!!!\n", outputStream.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {
        View view = new View();
        ArrayList<String> expectedBookList = new ArrayList<String>();
        String book1 = new String("Harry Potter");
        String book2 = new String("Head First Java");
        expectedBookList.add(book1);
        expectedBookList.add(book2);
        Library library = new Library(expectedBookList);
        ArrayList<String> actualBookList = library.showList();

        view.printListOfBooks(actualBookList);

        assertEquals("Harry Potter\nHead First Java\n", outputStream.toString());
    }
}




