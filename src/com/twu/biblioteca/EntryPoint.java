package com.twu.biblioteca;

import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        Input input = new Input();
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008", true);
        Book book2 = new Book("Data Structures", "Forouzan", "2002", true);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);

        Library library = new Library(bookList);
        Dispatcher dispatcher = new Dispatcher(view, library, input);
        BibliotecaApp bibliotecaapp = new BibliotecaApp(view, dispatcher);
        bibliotecaapp.start();
    }
}

