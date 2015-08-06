package com.twu.biblioteca.controller;

import com.twu.biblioteca.view.WelcomeView;


public class BibliotecaApp {

    private WelcomeView welcomeView;

    public BibliotecaApp(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    public void start() {
        welcomeView.render(new com.twu.biblioteca.model.User("", "", "", "", "", ""));
    }
}

