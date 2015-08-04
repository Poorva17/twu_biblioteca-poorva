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
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        ArrayList<Movie> checkoutMovieList = new ArrayList<Movie>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        Library library = new Library(availableBookList, checkoutBookList, availableMovieList, checkoutMovieList);
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(1);
        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice());

        Mockito.verify(view).printListOfBooks(library.getAvailableBooklist());
    }

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs4() {
        View view = Mockito.mock(View.class);

        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        Library library = Mockito.mock(Library.class);
        when(library.getAvailableMovieList()).thenReturn(availableMovieList);
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(4);
        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice());

        Mockito.verify(view).printListOfMovies(library.getAvailableMovieList());
    }

    @Test
    public void shouldCallPrintMovieCheckoutStatusWhenChoiceIs5() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(library.movieCheckout("Krish")).thenReturn(new Movie("Krish", "2011", "Rakesh Roshan", "4"));
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(5);
        when(input.acceptInput()).thenReturn("Krish");
        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice());

        Mockito.verify(view).printMovieCheckoutStatus(library.movieCheckout("Krish"));
    }

    @Test
    public void shouldCallPrintMovieCheckinStatusWhenChoiceIs6() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(library.movieCheckin("Krish")).thenReturn(new Movie("Krish", "2011", "Rakesh Roshan", "4"));
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(6);
        when(input.acceptInput()).thenReturn("Krish");
        Dispatcher dispatcher = new Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice());

        Mockito.verify(view).printMovieCheckinStatus(library.movieCheckin("Krish"));
    }
}
