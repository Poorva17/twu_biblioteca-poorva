package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.View;
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
        ArrayList<Item> availableBookList = new ArrayList<Item>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        Section bookSection = Mockito.mock(Section.class);
        Section movieSection = Mockito.mock(Section.class);
        when(bookSection.getAvailableItemList()).thenReturn(availableBookList);
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(1);
        Dispatcher dispatcher = new Dispatcher(view, bookSection, movieSection, input);
        User currentUser = Mockito.mock(User.class);
        when(currentUser.isAdmin()).thenReturn(true);

        dispatcher.dispatch(1, currentUser);

        Mockito.verify(view).printListOfBooks(bookSection.getAvailableItemList());
    }

    @Test
    public void shouldCallPrintListMethodWhenChoiceIs4() {
        View view = Mockito.mock(View.class);

        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Item> availableMovieList = new ArrayList<Item>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        Section bookSection = Mockito.mock(Section.class);
        Section movieSection = Mockito.mock(Section.class);
        when(movieSection.getAvailableItemList()).thenReturn(availableMovieList);
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(1);
        Dispatcher dispatcher = new Dispatcher(view, bookSection, movieSection, input);
        User currentUser = Mockito.mock(User.class);
        when(currentUser.isAdmin()).thenReturn(true);

        dispatcher.dispatch(4, currentUser);

        Mockito.verify(view).printListOfMovies(movieSection.getAvailableItemList());
    }

    @Test
    public void shouldCallPrintMovieCheckoutStatusWhenChoiceIs5() {
        View view = Mockito.mock(View.class);
        Section movieSection = Mockito.mock(Section.class);
        Section bookSection = Mockito.mock(Section.class);
        User currentUser = Mockito.mock(User.class);
        when(currentUser.isAdmin()).thenReturn(true);
        when(movieSection.itemCheckout("Krish", currentUser)).thenReturn(new Movie("Krish", "2011", "Rakesh Roshan", "4"));
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(5);
        when(input.acceptInput()).thenReturn("Krish");
        Dispatcher dispatcher = new Dispatcher(view, bookSection, movieSection, input);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printMovieCheckoutStatus((Movie) movieSection.itemCheckout("Krish", currentUser));
    }

    @Test
    public void shouldCallPrintMovieCheckinStatusWhenChoiceIs6() {
        View view = Mockito.mock(View.class);
        Section movieSection = Mockito.mock(Section.class);
        Section bookSection = Mockito.mock(Section.class);
        User currentUser = Mockito.mock(User.class);
        when(currentUser.isAdmin()).thenReturn(true);
        when(movieSection.itemCheckin("Krish", currentUser)).thenReturn(new Movie("Krish", "2011", "Rakesh Roshan", "4"));
        Input input = mock(Input.class);
        when(input.acceptChoice()).thenReturn(6);
        when(input.acceptInput()).thenReturn("Krish");
        Dispatcher dispatcher = new Dispatcher(view, bookSection, movieSection, input);

        dispatcher.dispatch(input.acceptChoice(), currentUser);

        Mockito.verify(view).printMovieCheckinStatus((Movie) movieSection.itemCheckin("Krish", currentUser));
    }
}
