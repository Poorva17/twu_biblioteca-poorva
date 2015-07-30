package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.HashMap;


public class DispatcherTest {

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs1() {
        int choice = 1;
        View view = Mockito.mock(View.class);
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
        Dispatcher dispatcher = new Dispatcher(view, bookList);

        dispatcher.dispatch(choice);

        Mockito.verify(view).printListOfBooks(bookList);
    }
}
