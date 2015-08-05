package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printListOfBooks(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.print(book.getDetails());
        }
    }

    public void printBookCheckoutStatus(Book checkoutReturnBook) {
        if (checkoutReturnBook.hasTitle(" "))
            System.out.print("That book is not available.\n");

        else
            System.out.print("Thank you! Enjoy the book\n");
    }

    public void printBookCheckinStatus(Book checkinReturnBook) {
        if (checkinReturnBook.hasTitle(" "))
            System.out.print("That is not a valid book to return.\n");
        else
            System.out.print("Thank you for returning the book.\n");

    }

    public void printListOfMovies(ArrayList<Movie> moviesList) {
        for (Movie movie : moviesList) {
            System.out.print(movie.getDetails());
        }
    }

    public void printMovieCheckoutStatus(Movie checkoutReturnMovie) {
        if (checkoutReturnMovie.hasTitle(" "))
            System.out.print("That movie is not available.\n");

        else
            System.out.print("Thank you! Enjoy the movie\n");
    }

    public void printMovieCheckinStatus(Movie checkinReturnMovie) {
        if (checkinReturnMovie.hasTitle(" "))
            System.out.print("That is not a valid movie to return.\n");
        else
            System.out.print("Thank you for returning the movie.\n");
    }

    public void printHashMapMovie(HashMap<Movie, User> movieCheckoutList) {
        for (Movie movie: movieCheckoutList.keySet()) {
            printMessage(movieCheckoutList.get(movie).displayInformation());
            printMessage(movie.getDetails());
        }
    }

    public void printHashMapBook(HashMap<Book, User> bookCheckoutList) {
        for (Book book: bookCheckoutList.keySet()) {
            printMessage(bookCheckoutList.get(book).displayInformation());
            printMessage(book.getDetails());
        }
    }
}




