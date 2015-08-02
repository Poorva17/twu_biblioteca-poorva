package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;
    private ArrayList<Movie> availableMovieList;
    private ArrayList<Movie> checkedOutMovieList;

    public Library(ArrayList<Book> availableBookList, ArrayList<Book> checkedOutBookList, ArrayList<Movie> availableMovieList, ArrayList<Movie> checkedOutMovieList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
        this.availableMovieList = availableMovieList;
        this.checkedOutMovieList = checkedOutMovieList;
    }

    public Book bookCheckout(String bookNameToCheckout) {
        for (Book book : availableBookList) {
            if (book.hasTitle(bookNameToCheckout)) {
                addBookToCheckoutList(book);
                return book;
            }
        }
        Book noBook = new Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToCheckoutList(Book book) {
        availableBookList.remove(book);
        checkedOutBookList.add(book);
    }

    public ArrayList<Book> getAvailableBooklist() {
        return availableBookList;
    }

    public Book bookCheckin(String bookNameToCheckin) {
        for (Book book : checkedOutBookList) {
            if (book.hasTitle(bookNameToCheckin)) {
                addBookToCheckinList(book);
                return book;
            }
        }
        Book noBook = new Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToCheckinList(Book book) {
        availableBookList.add(book);
        checkedOutBookList.remove(book);
    }

    public ArrayList<Book> getBookCheckoutList() {
        return checkedOutBookList;
    }

    public ArrayList<Movie> getAvailableMovieList() {
        return availableMovieList;
    }


    public Movie movieCheckout(String movieNameToCheckout) {
        for (Movie movie : availableMovieList) {
            if (movie.hasTitle(movieNameToCheckout)) {
                addMovieToCheckoutList(movie);
                return movie;
            }
        }
        Movie noMovie = new Movie(" ", " ", " ", " ");
        return noMovie;
    }

    private void addMovieToCheckoutList(Movie movie) {
        availableMovieList.remove(movie);
        checkedOutMovieList.add(movie);
    }
}
