package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    View view;
    ListOfBooks bookList;

    public BibliotecaApp(View view, ListOfBooks bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public static void main(String[] args) {
        View view = new View();
        view.printWelcomeMessage();
        ArrayList<Book> bookList = new ArrayList<Book>();
        ListOfBooks listOfBooks = new ListOfBooks(bookList);

        listOfBooks.addBooks();
        listOfBooks.showList();
    }
}

