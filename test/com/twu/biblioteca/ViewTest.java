package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


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
        String welcomeMessage = "Welcome to Biblioteca\n";
        view.printMessage(welcomeMessage);

        Assert.assertEquals("Welcome to Biblioteca\n", outputStream.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {

        View view = new View();
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkoutBookList = new ArrayList<Book>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        Library library = new Library(availableBookList, checkoutBookList);
        view.printListOfBooks(library.getAvailableBooklist());

        Assert.assertEquals("Computer Networks\tTaneunbaum\t2008\nData Structures\tForouzan\t2002\n", outputStream.toString());
    }
}
