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
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008", true);
        Book book2 = new Book("Data Structures", "Forouzan", "2002", true);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        Library library = new Library(bookList);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn(1);

        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch();

        Mockito.verify(view).printListOfBooks(library);
    }
}
