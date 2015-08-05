package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;
    private ArrayList<Movie> availableMovieList;
    private ArrayList<Movie> checkedOutMovieList;
    private HashMap<Book, User> userBookList;
    private HashMap<Movie, User> userMovieList;

    public Library(ArrayList<Book> availableBookList, ArrayList<Book> checkedOutBookList, ArrayList<Movie> availableMovieList,
                   ArrayList<Movie> checkedOutMovieList, HashMap<Book, User> userBookList, HashMap<Movie, User> userMovieList) {
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
        userBookList.put(book, currentUser);
    }

    public ArrayList<Book> getAvailableBooklist() {
        return availableBookList;
    }

    public Book bookCheckin(String bookNameToCheckin, User currentUser) {
        for (Book book : userBookList.keySet()) {
            if (book.hasTitle(bookNameToCheckin)) {
                if (userBookList.get(book).equals(currentUser)) {
                    addBookToAvailableList(book);
                    return book;
                }
            }
        }
        Book noBook = new Book(" ", " ", " ");
        return noBook;
    }

    private void addBookToAvailableList(Book book) {
        availableBookList.add(book);
        userBookList.remove(book);
    }

    public HashMap<Book, User> getBookCheckoutList() {
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
