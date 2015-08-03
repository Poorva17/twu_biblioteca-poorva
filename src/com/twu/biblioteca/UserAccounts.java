package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAccounts {
    ArrayList<User> userList;

    public UserAccounts(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User displayInformation(String userId, String password) {
        for (User user : userList) {
            if (user.matchCredentials(userId, password)) {
                return user;
            }
        }
        return new User("", "", "", "", "");
    }
}
