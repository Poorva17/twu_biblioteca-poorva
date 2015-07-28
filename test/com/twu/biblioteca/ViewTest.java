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
        original = System.out;
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

        ArrayList<String[]> actualBookList = new ArrayList<String[]>();
        String[] book1 = new String[3];
        String[] book2 = new String[3];
        book1[0] = "Harry Potter";
        book1[1] = "J K Rolling";
        book1[2] = "1994";
        book2[0] = "Head First Java";
        book2[1] = "Sierra";
        book2[2] = "2008";
        actualBookList.add(book1);
        actualBookList.add(book2);
        View view = new View();

        view.printListOfBooks(actualBookList);

        assertEquals("Harry Potter\tJ K Rolling\t1994\nHead First Java\tSierra\t2008\n", outputStream.toString());
    }
}




