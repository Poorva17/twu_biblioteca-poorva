package com.twu.biblioteca;

public class Setup {
    View view;

    public Setup(View view) {
        this.view = view;
    }

    public void showWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca";
        view.printMessage(welcomeMessage);
    }

    public void showMenu() {
        view.printMessage("Menu");
        view.printMessage("1.List Of Books");
        view.printMessage("2.Quit");
    }
}
