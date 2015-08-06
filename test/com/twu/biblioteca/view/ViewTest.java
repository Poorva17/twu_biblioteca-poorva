package com.twu.biblioteca.view;

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
        com.twu.biblioteca.model.Book book1 = new com.twu.biblioteca.model.Book("Computer Networks", "Taneunbaum", "2008");
        com.twu.biblioteca.model.Book book2 = new com.twu.biblioteca.model.Book("Data Structures", "Forouzan", "2002");
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);

        view.printListOfBooks(library.getAvailableBooklist());

        Assert.assertEquals("Computer Networks\tTaneunbaum\t2008\nData Structures\tForouzan\t2002\n", outputStream.toString());
    }
}
