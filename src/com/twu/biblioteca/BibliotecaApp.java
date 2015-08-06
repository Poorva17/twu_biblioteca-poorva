package com.twu.biblioteca;

public class BibliotecaApp {
    Dispatcher dispatcher;
    View view;
    Login login;
    Input input;
    WelcomeView welcomeView;

    public BibliotecaApp(View view, Dispatcher dispatcher, Login login, Input input, WelcomeView welcomeView) {
        this.view = view;
        this.dispatcher = dispatcher;
        this.login = login;
        this.input = input;
        this.welcomeView = welcomeView;
    }

    public void start() {
        welcomeView.render(new User("", "", "", "", "", ""));
    }
}

