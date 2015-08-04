package com.twu.biblioteca;

import java.util.ArrayList;


public class UserAccounts {
    ArrayList<User> userList;

    public UserAccounts(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String checkLogin(String userCredentials) {
        for (User user : userList) {
            if (user.matchCredentials(userCredentials)) {
                return user.displayInformation();
            }
        }
        return "User authentication error!!!\n";
    }
}
