package com.twu.biblioteca;


public class BibliotecaApp {
    View view = new View();

    public BibliotecaApp(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        view.printWelcomeMessage();
    }
}

