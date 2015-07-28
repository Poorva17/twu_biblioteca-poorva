package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    View view;
    Library bookList;

    public BibliotecaApp(View view, Library bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public static void main(String[] args) {
        View view = new View();
        view.printWelcomeMessage();
        ArrayList<String> book = new ArrayList<String>();
        book.add("Harry Potter");
        book.add("Head First Java");

        Library listOfBooks = new Library(book);

        view.printListOfBooks(listOfBooks.showList());
    }
}


