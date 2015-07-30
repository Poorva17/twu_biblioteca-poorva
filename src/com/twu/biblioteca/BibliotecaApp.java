package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class BibliotecaApp {
    View view;
    ArrayList<HashMap<String, String>> bookList;

    public BibliotecaApp(View view, ArrayList<HashMap<String, String>> bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public ArrayList<HashMap<String, String>> getGetBookList() {
        return this.bookList;
    }

    public void start() {
        view.printListOfBooks(bookList);
    }
}

