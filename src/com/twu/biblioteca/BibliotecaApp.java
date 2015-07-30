package com.twu.biblioteca;

public class BibliotecaApp {
    View view;
    Setup setup;
    Input input;
    Dispatcher dispatcher;

    public BibliotecaApp(View view, Setup setup, Input input, Dispatcher dispatcher) {
        this.view = view;
        this.setup = setup;
        this.input = input;
        this.dispatcher = dispatcher;
    }

    public void start() {
        setup.showWelcomeMessage();
        setup.showMenu();
        while(true) {
            dispatcher.dispatch(input.acceptInput());
            setup.showMenu();
        }
    }
}

