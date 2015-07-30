package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        Setup setup = new Setup(view);
        setup.showWelcomeMessage();
        setup.showMenu();
        ArrayList<HashMap<String, String>> preexistingBookList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Name Of Book", "Computer Networks");
        book1.put("Author", "Taneunbaum");
        book1.put("Year Published", "2008");

        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Name Of Book", "Data Structures");
        book2.put("Author", "Forouzan");
        book2.put("Year Published", "2002");

        preexistingBookList.add(book1);
        preexistingBookList.add(book2);

        BibliotecaApp bibliotecaapp = new BibliotecaApp(view, preexistingBookList);
        bibliotecaapp.start();
        int choice = 0;
        Input input = new Input(choice, view);
        choice = input.acceptInput();
        Dispatcher dispatcher = new Dispatcher(choice, view, preexistingBookList);
        dispatcher.dispatch();
    }
}

