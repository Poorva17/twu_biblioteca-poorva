package com.twu.biblioteca;

public class InvalidView implements IView{

    public void render(User invalidUser) {
        System.out.print("\nAuthentication Error!!!\n");
    }
}
