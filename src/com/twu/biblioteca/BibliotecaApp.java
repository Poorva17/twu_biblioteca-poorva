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
        String[] book1 = new String[3];
        String[] book2 = new String[3];
        book1[0] = "Harry Potter";
        book1[1] = "ABC";
        book1[2] = "1994";
        book2[0] = "XYZ";
        book2[1] = "XYZA";
        book2[2] = "1995";
        ArrayList<String[]> library = new ArrayList<String[]>();
        library.add(book1);
        library.add(book2);
        view.printWelcomeMessage();
        view.printListOfBooks(library);
    }
}


