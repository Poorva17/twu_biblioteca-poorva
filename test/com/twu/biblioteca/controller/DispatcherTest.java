package com.twu.biblioteca.controller;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DispatcherTest {

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs1() {
        com.twu.biblioteca.view.View view = Mockito.mock(com.twu.biblioteca.view.View.class);
        com.twu.biblioteca.model.Book book1 = new com.twu.biblioteca.model.Book("Computer Networks", "Taneunbaum", "2008");
        com.twu.biblioteca.model.Book book2 = new com.twu.biblioteca.model.Book("Data Structures", "Forouzan", "2002");
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        ArrayList<com.twu.biblioteca.model.Book> checkoutBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        ArrayList<com.twu.biblioteca.model.Movie> checkoutMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        com.twu.biblioteca.model.Library library = Mockito.mock(com.twu.biblioteca.model.Library.class);
        com.twu.biblioteca.view.Input input = mock(com.twu.biblioteca.view.Input.class);
        when(input.acceptChoice()).thenReturn(1);
        com.twu.biblioteca.controller.Dispatcher dispatcher = new com.twu.biblioteca.controller.Dispatcher(view, library, input);
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printListOfBooks(library.getAvailableBooklist());
    }

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs4() {
        com.twu.biblioteca.view.View view = Mockito.mock(com.twu.biblioteca.view.View.class);

        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        com.twu.biblioteca.model.Library library = Mockito.mock(com.twu.biblioteca.model.Library.class);
        when(library.getAvailableMovieList()).thenReturn(availableMovieList);
        com.twu.biblioteca.view.Input input = mock(com.twu.biblioteca.view.Input.class);
        when(input.acceptChoice()).thenReturn(4);
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        com.twu.biblioteca.controller.Dispatcher dispatcher = new com.twu.biblioteca.controller.Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printListOfMovies(library.getAvailableMovieList());
    }

    @Test
    public void shouldCallPrintMovieCheckoutStatusWhenChoiceIs5() {
        com.twu.biblioteca.view.View view = Mockito.mock(com.twu.biblioteca.view.View.class);
        com.twu.biblioteca.model.Library library = Mockito.mock(com.twu.biblioteca.model.Library.class);
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        when(library.movieCheckout("Krish", currentUser)).thenReturn(new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4"));
        com.twu.biblioteca.view.Input input = mock(com.twu.biblioteca.view.Input.class);
        when(input.acceptChoice()).thenReturn(5);
        when(input.acceptInput()).thenReturn("Krish");
        com.twu.biblioteca.controller.Dispatcher dispatcher = new com.twu.biblioteca.controller.Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printMovieCheckoutStatus(library.movieCheckout("Krish", currentUser));
    }

    @Test
    public void shouldCallPrintMovieCheckinStatusWhenChoiceIs6() {
        com.twu.biblioteca.view.View view = Mockito.mock(com.twu.biblioteca.view.View.class);
        com.twu.biblioteca.model.Library library = Mockito.mock(com.twu.biblioteca.model.Library.class);
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        when(library.movieCheckin("Krish", currentUser)).thenReturn(new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4"));
        com.twu.biblioteca.view.Input input = mock(com.twu.biblioteca.view.Input.class);
        when(input.acceptChoice()).thenReturn(6);
        when(input.acceptInput()).thenReturn("Krish");
        com.twu.biblioteca.controller.Dispatcher dispatcher = new com.twu.biblioteca.controller.Dispatcher(view, library, input);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printMovieCheckinStatus(library.movieCheckin("Krish", currentUser));
    }
}
