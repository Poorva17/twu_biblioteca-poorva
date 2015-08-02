package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(bufferedReader);
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkoutBookList = new ArrayList<Book>();
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<Movie> checkoutMovieList = new ArrayList<Movie>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        Library library = new Library(availableBookList, checkoutBookList, availableMovieList, checkoutMovieList);
        Dispatcher dispatcher = new Dispatcher(view, library, input);
        BibliotecaApp bibliotecaapp = new BibliotecaApp(view, dispatcher);
        bibliotecaapp.start();
    }
}

