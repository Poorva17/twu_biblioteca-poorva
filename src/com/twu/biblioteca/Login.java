package com.twu.biblioteca;

public class Login {
    Input input;
    UserAccounts userAccounts;
    View view;

    public Login(UserAccounts userAccounts, Input input, View view) {
        this.userAccounts = userAccounts;
        this.input = input;
        this.view = view;
    }

    public String checkLogin() {
        view.printMessage("Welcome to Biblioteca!!!\n");
        view.printMessage("-----------------------------------------------\n");
        view.printMessage("Enter Username:\n");
        String userName = input.acceptInput();
        view.printMessage("Enter Password:\n");
        String password = input.acceptInput();
        return (userAccounts.checkLogin(userName, password).split(" ")[0]);
    }
}
