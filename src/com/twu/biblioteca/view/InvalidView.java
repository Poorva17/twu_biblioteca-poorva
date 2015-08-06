package com.twu.biblioteca.view;

import com.twu.biblioteca.model.User;

public class InvalidView implements IView {

    public void render(User invalidUser) {
        System.out.print("\nAuthentication Error!!!\n");
    }
}
