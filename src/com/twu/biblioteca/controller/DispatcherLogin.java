package com.twu.biblioteca.controller;

import com.twu.biblioteca.view.AdminMenuView;
import com.twu.biblioteca.view.InvalidView;
import com.twu.biblioteca.view.UserMenuView;

public class DispatcherLogin {

    private Login login;
    private AdminMenuView adminView;
    private UserMenuView userView;
    private InvalidView invalidView;

    public DispatcherLogin(Login login, AdminMenuView adminView, UserMenuView userView, InvalidView invalidView) {
        this.login = login;
        this.adminView = adminView;
        this.userView = userView;
        this.invalidView = invalidView;
    }

    public com.twu.biblioteca.model.User dispatch(int choice) {
        if (choice == 1) {
            return login.checkLogin();
        }
        else if (choice == 2) {
            System.exit(0);
        }
        return null;
    }

    public com.twu.biblioteca.view.IView dispatchMenu(com.twu.biblioteca.model.User user) {
        if (user.isAdmin()) {
            return adminView;
        }
        else if (user.isUser()) {
            return userView;
        }
        return invalidView;
    }
}
