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

    public User checkLogin() {
        boolean isSuccessfulLogin = false;
        String userName = "";
        String password = "";
        while (!isSuccessfulLogin) {
            view.printMessage("Welcome to Biblioteca!!!\n");
            view.printMessage("-----------------------------------------------\n");
            view.printMessage("Enter Username:\n");
            userName = input.acceptInput();
            view.printMessage("Enter Password:\n");
            password = input.acceptInput();
            if (userAccounts.checkLogin(userName, password)) {
                isSuccessfulLogin = true;
            }
        }
        return userAccounts.getUser(userName, password);
    }
}
