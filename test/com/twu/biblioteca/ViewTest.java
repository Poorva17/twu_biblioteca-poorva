package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;


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
        String welcomeMessage = "Welcome to Biblioteca";
        view.printMessage(welcomeMessage);

        Assert.assertEquals("Welcome to Biblioteca\n", outputStream.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {

        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Name Of Book", "Computer Networks");
        book1.put("Author", "Taneunbaum");
        book1.put("Year Published", "2008");

        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Name Of Book", "Data Structures");
        book2.put("Author", "Forouzan");
        book2.put("Year Published", "2002");

        bookList.add(book1);
        bookList.add(book2);
        View view = new View();

        view.printListOfBooks(bookList);

        Assert.assertEquals("Computer Networks\tTaneunbaum\t2008\nData Structures\tForouzan\t2002\n", outputStream.toString());
    }
}
