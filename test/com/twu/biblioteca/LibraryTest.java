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
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        ArrayList<Movie> checkedoutMovieList = new ArrayList<Movie>();
        Library library = new Library(availableBookList, checkedoutBookList, availableMovieList, checkedoutMovieList);

        assertEquals(book1, library.bookCheckout("Computer Networks"));
    }

    @Test
    public void shouldReturnValidBook() {
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        checkedoutBookList.add(book1);
        availableBookList.add(book2);
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        ArrayList<Movie> checkedoutMovieList = new ArrayList<Movie>();
        Library library = new Library(availableBookList, checkedoutBookList, availableMovieList, checkedoutMovieList);

        assertEquals(book1, library.bookCheckin("Computer Networks"));
    }

    @Test
    public void shouldReturnAvailableMovieList() {
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<Movie> checkedoutMovieList = new ArrayList<Movie>();
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> chekedoutBookList = new ArrayList<Book>();
        Library library = new Library(availableBookList, chekedoutBookList, availableMovieList, checkedoutMovieList);

        assertEquals(availableMovieList, library.getAvailableMovieList());
    }

    @Test
    public void shouldCheckoutMovieIfAvailable() {
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<Movie> checkedoutMovieList = new ArrayList<Movie>();
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> chekedoutBookList = new ArrayList<Book>();
        Library library = new Library(availableBookList, chekedoutBookList, availableMovieList, checkedoutMovieList);

        assertEquals(movie1, library.movieCheckout("Krish"));

    }

    @Test
    public void shouldReturnNomovieToCheckoutMovieIfNotAvailable() {
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        Movie noMovie = new Movie(" ", " ", " ", " ");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<Movie> checkedoutMovieList = new ArrayList<Movie>();
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> chekedoutBookList = new ArrayList<Book>();
        Library library = new Library(availableBookList, chekedoutBookList, availableMovieList, checkedoutMovieList);
        library.movieCheckout("Krish");

        assertEquals(noMovie, library.movieCheckout("Krish"));

    }
}
