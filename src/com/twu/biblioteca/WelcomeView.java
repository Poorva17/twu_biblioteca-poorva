package com.twu.biblioteca;

public class WelcomeView implements IView {
    Input input;
    IView nextView;
    DispatcherLogin dispatcherLogin;

    public WelcomeView(Input input, DispatcherLogin dispatcherLogin) {
        this.input = input;
        this.dispatcherLogin = dispatcherLogin;
    }

    public void render(User user) {
        while (true) {
            System.out.print("Welcome to Biblioteca!!!\n");
            System.out.print("\n\t1. Login");
            System.out.print("\n\t2. Quit");
            System.out.print("\n\tEnter your choice:\n");
            user = dispatcherLogin.dispatch(input.acceptChoice());
            nextView = dispatcherLogin.dispatchMenu(user);
            nextView.render(user);
        }
    }
}
