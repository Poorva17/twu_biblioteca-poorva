package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.model.UserAccounts;


public class Login {

    Input input;
    UserAccounts userAccounts;
    com.twu.biblioteca.view.View view;

    public Login(UserAccounts userAccounts, Input input, com.twu.biblioteca.view.View view) {
        this.userAccounts = userAccounts;
        this.input = input;
        this.view = view;
    }

    public User checkLogin() {
        view.printMessage("Welcome to Biblioteca!!!\n");
        view.printMessage("-----------------------------------------------\n");
        view.printMessage("Enter Username:\n");
        String userName = input.acceptInput();
        view.printMessage("Enter Password:\n");
        String password = input.acceptInput();
        userAccounts.checkLogin(userName, password);
        return userAccounts.getUser(userName, password);
    }
}
