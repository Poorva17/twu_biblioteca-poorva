package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Dispatcher {
    private int choice;
    private View view;
    private ArrayList<HashMap<String,String>> bookList;

    public Dispatcher(int choice, View view, ArrayList<HashMap<String, String>> bookList) {
        this.choice = choice;
        this.view = view;
        this.bookList = bookList;
    }

    public void dispatch() {
        switch (choice) {
            case 1:
                view.printListOfBooks(this.bookList);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!");
        }
    }
}