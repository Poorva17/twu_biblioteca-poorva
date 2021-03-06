package com.twu.biblioteca.model;

import java.util.ArrayList;


public class UserAccounts {
    private ArrayList<User> userList;

    public UserAccounts(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean checkLogin(String userName, String password) {
        for (User user : userList) {
            if (user.matchCredentials(userName, password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String userName, String password) {
        for (User user : userList) {
            if (user.matchCredentials(userName, password)) {
                return user;
            }
        }
        return new User("", "", "", "", "", "");
    }
}
