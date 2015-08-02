package com.twu.biblioteca;

public class BibliotecaApp {
    Dispatcher dispatcher;
    View view;

    public BibliotecaApp(View view, Dispatcher dispatcher) {
        this.view = view;
        this.dispatcher = dispatcher;
    }

    public void start() {
        view.printMessage("Welcome to Biblioteca!!!\n");
        view.printMessage("-----------------------------------------------\n");

        while(true) {
            view.printMessage("Menu\n");
            view.printMessage("-----------------------------------------------\n");
            view.printMessage("1.List of Books\n" + "2.Checkout Book\n" + "3.Return Book\n" +
                    "4.List Checkout Books\n" + "5.List of Movies\n" + "6.Checkout Movie\n" + "7.Quit\n");
            view.printMessage("Enter your choice:\n");
            dispatcher.dispatch();
            view.printMessage("\n-----------------------------------------------\n\n");
        }
    }
}

