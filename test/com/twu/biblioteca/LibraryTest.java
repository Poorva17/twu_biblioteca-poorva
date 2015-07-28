package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<String> expectedBookList = new ArrayList<String>();
        String book1 = new String("Harry Potter");
        String book2 = new String("Head First Java");

        expectedBookList.add(book1);
        expectedBookList.add(book2);

        Library library = new Library(expectedBookList);
        ArrayList<String> actualBookList = library.showList();

        assertEquals(expectedBookList, actualBookList);
    }
}


