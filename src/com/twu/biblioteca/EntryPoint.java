package com.twu.biblioteca;

import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        Input input = new Input();
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkoutBookList = new ArrayList<Book>();
        availableBookList.add(book1);
        availableBookList.add(book2);

        Library library = new Library(availableBookList, checkoutBookList);
        Dispatcher dispatcher = new Dispatcher(view, library, input);
        BibliotecaApp bibliotecaapp = new BibliotecaApp(view, dispatcher);
        bibliotecaapp.start();
    }
}

