package com.twu.biblioteca.view;

import com.twu.biblioteca.model.*;
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
        com.twu.biblioteca.view.View view = new com.twu.biblioteca.view.View();
        String welcomeMessage = "Welcome to Biblioteca\n";
        view.printMessage(welcomeMessage);

        Assert.assertEquals("Welcome to Biblioteca\n", outputStream.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {

        com.twu.biblioteca.view.View view = new com.twu.biblioteca.view.View();
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Item> availableBookList = new ArrayList<Item>();
        ArrayList<Item> availableMovieList = new ArrayList<Item>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        HashMap<Item, User> userBookList = new HashMap<Item, User>();
        HashMap<Item, User> userMovieList = new HashMap<Item, User>();
        Section bookSection = new Section(availableBookList, userBookList);
        Section movieSection = new Section(availableMovieList, userMovieList);

        view.printListOfBooks(bookSection.getAvailableItemList());

        Assert.assertEquals("Computer Networks    Taneunbaum           2008                \n" +
                "Data Structures      Forouzan             2002                \n", outputStream.toString());
    }
}
