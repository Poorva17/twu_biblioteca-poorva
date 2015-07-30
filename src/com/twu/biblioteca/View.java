package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printListOfBooks(ArrayList<HashMap<String, String>> bookList) {
        for (HashMap<String, String> book : bookList) {
            System.out.println(book.get("Name Of Book")+ "\t" + book.get("Author") + "\t" + book.get("Year Published"));
        }
    }
}




