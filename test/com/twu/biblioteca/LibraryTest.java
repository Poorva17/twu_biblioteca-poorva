package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldCheckoutBookIfAvailable() {
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        availableBookList.add(book1);
        availableBookList.add(book2);

        Library library = new Library(availableBookList, checkedoutBookList);

        assertEquals(true, library.checkout("Computer Networks"));
    }

    @Test
    public void shouldReturnValidBook() {
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();

        checkedoutBookList.add(book1);
        availableBookList.add(book2);

        Library library = new Library(availableBookList, checkedoutBookList);

        assertEquals(true, library.checkin("Computer Networks"));
    }
}
