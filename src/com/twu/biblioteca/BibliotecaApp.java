package com.twu.biblioteca;

import java.util.ArrayList;


public class BibliotecaApp {
    View view;
    ArrayList<String[]> bookList;

    public BibliotecaApp(View view) {
        this.view = view;
        this.bookList = null;
    }

    public ArrayList<String[]> createBookList() {
        ArrayList<String[]> actualBookList = new ArrayList<String[]>();
        String[] book1 = new String[3];
        String[] book2 = new String[3];
        book1[0] = "Harry Potter";
        book1[1] = "J K Rolling";
        book1[2] = "1994";
        book2[0] = "Head First Java";
        book2[1] = "Sierra";
        book2[2] = "2008";
        actualBookList.add(book1);
        actualBookList.add(book2);

        this.bookList = actualBookList;
        return actualBookList;
    }

    public void printWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca";
        view.printMessage(welcomeMessage);
    }
    public void showList() {
        view.printListOfBooks(this.bookList);
    }

    public void showMenu() {
        view.printMessage("Menu");
        view.printMessage("1.List Of Books");
        view.printMessage("2.Quit");
    }
}

