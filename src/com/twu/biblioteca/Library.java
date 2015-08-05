package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;
    private ArrayList<Movie> availableMovieList;
    private ArrayList<Movie> checkedOutMovieList;
    private HashMap<User, ArrayList<Book>> userBookList;
    private HashMap<User, ArrayList<Movie>> userMovieList;

    public Library(ArrayList<Book> availableBookList, ArrayList<Book> checkedOutBookList, ArrayList<Movie> availableMovieList,
                   ArrayList<Movie> checkedOutMovieList, HashMap<User, ArrayList<Book>> userBookList, HashMap<User,
            ArrayList<Movie>> userMovieList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
        this.availableMovieList = availableMovieList;
        this.checkedOutMovieList = checkedOutMovieList;
        this.userBookList = userBookList;
        this.userMovieList = userMovieList;
    }

    public Book bookCheckout(String bookNameToCheckout, User currentUser) {
        for (Book book : availableBookList) {
            if (book.hasTitle(bookNameToCheckout)) {
                addBookToCheckoutList(book, currentUser);
                return book;
            }
        }
        Book noBook = new Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToCheckoutList(Book book, User currentUser) {
        availableBookList.remove(book);
        checkedOutBookList.add(book);
    }

    public ArrayList<Book> getAvailableBooklist() {
        return availableBookList;
    }

    public Book bookCheckin(String bookNameToCheckin, User currentUser) {
        for (Book book : checkedOutBookList) {
            if (book.hasTitle(bookNameToCheckin)) {
                addBookToAvailableList(book);
                return book;
            }
        }
        Book noBook = new Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToAvailableList(Book book) {
        availableBookList.add(book);
        checkedOutBookList.remove(book);
    }

    public ArrayList<Book> getBookCheckoutList() {
        return checkedOutBookList;
    }

    public ArrayList<Movie> getAvailableMovieList() {
        return availableMovieList;
    }


    public Movie movieCheckout(String movieNameToCheckout, User currentUser) {
        for (Movie movie : availableMovieList) {
            if (movie.hasTitle(movieNameToCheckout)) {
                addMovieToCheckoutList(movie, currentUser);
                return movie;
            }
        }
        Movie noMovie = new Movie(" ", " ", " ", " ");
        return noMovie;
    }

    private void addMovieToCheckoutList(Movie movie, User currentUser) {
        availableMovieList.remove(movie);
        checkedOutMovieList.add(movie);
    }

    public Movie movieCheckin(String movieNameToCheckin, User currentUser) {
        for (Movie movie : checkedOutMovieList) {
            if (movie.hasTitle(movieNameToCheckin)) {
                addMovieToAvailableList(movie);
                return movie;
            }
        }
        Movie noMovie = new Movie(" ", " ", " ", " ");
        return noMovie;
    }

    private void addMovieToAvailableList(Movie movie) {
        availableMovieList.add(movie);
        checkedOutMovieList.remove(movie);
    }

    public ArrayList<Movie> getMovieCheckoutList() {
        return checkedOutMovieList;
    }
}
