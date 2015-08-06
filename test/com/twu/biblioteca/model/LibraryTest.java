package com.twu.biblioteca.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldCheckoutBookIfAvailable() {
        com.twu.biblioteca.model.Book book1 = new com.twu.biblioteca.model.Book("Computer Networks", "Taneunbaum", "2008");
        com.twu.biblioteca.model.Book book2 = new com.twu.biblioteca.model.Book("Data Structures", "Forouzan", "2002");
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);

        assertEquals(book1, library.bookCheckout("Computer Networks", currentUser));
    }

    @Test
    public void shouldReturnValidBook() {
        com.twu.biblioteca.model.Book book1 = new com.twu.biblioteca.model.Book("Computer Networks", "Taneunbaum", "2008");
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        userBookList.put(book1, currentUser);
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);

        assertEquals(book1, library.bookCheckin("Computer Networks", currentUser));
    }

    @Test
    public void shouldReturnAvailableMovieList() {
        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);


        assertEquals(availableMovieList, library.getAvailableMovieList());
    }

    @Test
    public void shouldCheckoutMovieIfAvailable() {
        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);

        assertEquals(movie1, library.movieCheckout("Krish", currentUser));

    }

    @Test
    public void shouldReturnNomovieToCheckoutMovieIfNotAvailable() {
        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie noMovie = new com.twu.biblioteca.model.Movie(" ", " ", " ", " ");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);
        library.movieCheckout("Krish", currentUser);

        assertEquals(noMovie, library.movieCheckout("Krish", currentUser));

    }

    @Test
    public void shouldCheckinValidMovie() {
        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        com.twu.biblioteca.model.User currentUser = Mockito.mock(com.twu.biblioteca.model.User.class);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);
        library.movieCheckout("Krish2", currentUser);

        assertEquals(movie2, library.movieCheckin("Krish2", currentUser));
    }
}
