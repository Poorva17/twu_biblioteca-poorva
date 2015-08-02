package com.twu.biblioteca;


import java.util.ArrayList;

public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printListOfBooks(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.print(book.getDetails());
        }
    }

    public void printCheckoutStatus(Book checkoutReturnBook) {
        if (checkoutReturnBook.hasTitle(" "))
            System.out.print("That book is not available.\n");

        else
            System.out.print("Thank you! Enjoy the book\n");
    }

    public void printCheckinStatus(Book checkinReturnBook) {
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

}




