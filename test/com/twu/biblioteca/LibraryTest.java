package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldCheckoutBookIfAvailable() {
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008", true);
        Book book2 = new Book("Data Structures", "Forouzan", "2002", true);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);

        Library library = new Library(bookList);

        assertEquals(true, library.checkout("Computer Networks"));
    }

    @Test
    public void shouldReturnValidBook() {
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008", true);
        Book book2 = new Book("Data Structures", "Forouzan", "2002", true);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);

        Library library = new Library(bookList);

        assertEquals(true, library.checkin("Computer Networks"));
    }
    
}
