package com.twu.biblioteca;

import java.util.ArrayList;

public class View {

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!!!");
    }

    public void printListOfBooks(ArrayList<String> bookList) {
        for (String book : bookList) {
            System.out.println(book);
        }
    }
}



