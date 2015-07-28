package com.twu.biblioteca;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.createBookList();
        bibliotecaApp.showList();
    }
}

