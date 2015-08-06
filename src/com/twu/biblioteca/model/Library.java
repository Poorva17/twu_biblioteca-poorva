package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<com.twu.biblioteca.model.Book> availableBookList;
    private ArrayList<Movie> availableMovieList;
    private HashMap<com.twu.biblioteca.model.Book, User> userBookList;
    private HashMap<Movie, User> userMovieList;

    public Library(ArrayList<com.twu.biblioteca.model.Book> availableBookList, ArrayList<Movie> availableMovieList,
                   HashMap<com.twu.biblioteca.model.Book, User> userBookList, HashMap<Movie, User> userMovieList) {
        this.availableBookList = availableBookList;
        this.availableMovieList = availableMovieList;
        this.userBookList = userBookList;
        this.userMovieList = userMovieList;
    }

    public com.twu.biblioteca.model.Book bookCheckout(String bookNameToCheckout, User currentUser) {
        for (com.twu.biblioteca.model.Book book : availableBookList) {
            if (book.hasTitle(bookNameToCheckout)) {
                addBookToCheckoutList(book, currentUser);
                return book;
            }
        }
        com.twu.biblioteca.model.Book noBook = new com.twu.biblioteca.model.Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToCheckoutList(com.twu.biblioteca.model.Book book, User currentUser) {
        availableBookList.remove(book);
        userBookList.put(book, currentUser);
    }

    public ArrayList<com.twu.biblioteca.model.Book> getAvailableBooklist() {
        return availableBookList;
    }

    public com.twu.biblioteca.model.Book bookCheckin(String bookNameToCheckin, User currentUser) {
        for (com.twu.biblioteca.model.Book book : userBookList.keySet()) {
            if (book.hasTitle(bookNameToCheckin)) {
                if (userBookList.get(book).equals(currentUser)) {
                    addBookToAvailableList(book);
                    return book;
                }
            }
        }
        com.twu.biblioteca.model.Book noBook = new com.twu.biblioteca.model.Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToAvailableList(com.twu.biblioteca.model.Book book) {
        availableBookList.add(book);
        userBookList.remove(book);
    }

    public HashMap<com.twu.biblioteca.model.Book, User> getBookCheckoutList() {
        return userBookList;
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
        userMovieList.put(movie, currentUser);
    }

    public Movie movieCheckin(String movieNameToCheckin, User currentUser) {
        for (Movie movie : userMovieList.keySet()) {
            if (movie.hasTitle(movieNameToCheckin)) {
                if (userMovieList.get(movie).equals(currentUser)) {
                    addMovieToAvailableList(movie);
                    return movie;
                }
            }
        }
        Movie noMovie = new Movie(" ", " ", " ", " ");
        return noMovie;
    }

    private void addMovieToAvailableList(Movie movie) {
        availableMovieList.add(movie);
        userMovieList.remove(movie);
    }

    public HashMap<Movie, User> getMovieCheckoutList() {
        return userMovieList;
    }
}
