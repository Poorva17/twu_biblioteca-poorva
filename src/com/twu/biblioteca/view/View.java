package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.User;
import java.util.ArrayList;
import java.util.HashMap;


public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printListOfBooks(ArrayList<Item> itemList) {
        for (Item item : itemList) {
            System.out.print(item.getDetails());
        }
    }

    public void printBookCheckoutStatus(Item checkoutReturnBook) {
        if (checkoutReturnBook.hasTitle(""))
            System.out.print("That book is not available.\n");

        else
            System.out.print("Thank you! Enjoy the book\n");
    }

    public void printBookCheckinStatus(Item checkinReturnBook) {
        if (checkinReturnBook.hasTitle(""))
            System.out.print("That is not a valid book to return.\n");
        else
            System.out.print("Thank you for returning the book.\n");

    }

    public void printListOfMovies(ArrayList<Item> moviesList) {
        for (Item movie : moviesList) {
            System.out.print(movie.getDetails());
        }
    }

    public void printMovieCheckoutStatus(Item checkoutReturnMovie) {
        if (checkoutReturnMovie.hasTitle(""))
            System.out.print("That movie is not available.\n");

        else
            System.out.print("Thank you! Enjoy the movie\n");
    }

    public void printMovieCheckinStatus(Item checkinReturnMovie) {
        if (checkinReturnMovie.hasTitle(""))
            System.out.print("That is not a valid movie to return.\n");
        else
            System.out.print("Thank you for returning the movie.\n");
    }

    public void printHashMapMovie(HashMap<Item, User> movieCheckoutList) {
        for (Item movie: movieCheckoutList.keySet()) {
            printMessage(movieCheckoutList.get(movie).getInformation());
            printMessage(movie.getDetails());
        }
    }

    public void printHashMapBook(HashMap<Item, User> bookCheckoutList) {
        for (Item book: bookCheckoutList.keySet()) {
            printMessage(bookCheckoutList.get(book).getInformation());
            printMessage(book.getDetails());
        }
    }
}




