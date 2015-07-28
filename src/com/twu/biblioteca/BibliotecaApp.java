package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    View view;
    ArrayList<String> bookList;

    public BibliotecaApp(View view, ArrayList<String> bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public static void main(String[] args) {
        View view = new View();
        ArrayList<String> library = new ArrayList<String>();
        String book1 = "Harry Potter";
        String book2 = "Head First Java";
        library.add(book1);
        library.add(book2);
        view.printWelcomeMessage();
        view.printListOfBooks(library);
    }
}


