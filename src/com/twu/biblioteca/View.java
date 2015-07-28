package com.twu.biblioteca;

import java.util.ArrayList;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printListOfBooks(ArrayList<String[]> bookList) {
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t" + book[2]);
        }
    }
}




