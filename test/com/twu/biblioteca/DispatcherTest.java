package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DispatcherTest {

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs1() {
        View view = Mockito.mock(View.class);
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkoutBookList = new ArrayList<Book>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        Library library = new Library(availableBookList, checkoutBookList);
        Input input = mock(Input.class);
        when(input.acceptInput()).thenReturn(1);
        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch();

        Mockito.verify(view).printListOfBooks(library.getAvailableBooklist());
    }
}
