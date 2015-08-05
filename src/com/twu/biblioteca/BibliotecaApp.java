package com.twu.biblioteca;

public class BibliotecaApp {
    Dispatcher dispatcher;
    View view;
    Login login;
    Input input;

    public BibliotecaApp(View view, Dispatcher dispatcher, Login login, Input input) {
        this.view = view;
        this.dispatcher = dispatcher;
        this.login = login;
        this.input = input;
    }

    public void start() {
        int continueApp = 1;
        while (continueApp == 1) {
            view.printMessage("\n\t1. Login\n");
            view.printMessage("\n\t2. Quit\n");
            view.printMessage("\n\tEnter your choice:\n");
            continueApp = input.acceptChoice();
            if (continueApp == 2) {
                System.exit(0);
            }
            User currentUser = login.checkLogin();
            menuOptionDispatch(currentUser);
        }
    }

    private void menuOptionDispatch(User currentUser) {
        int choice;
        while (true) {
            if (currentUser.isAdmin()) {
                printAdminMenu();
                choice = input.acceptChoice();
                if (choice == 9) {
                    break;
                }
                dispatcher.dispatch(choice, currentUser);
            }
            else if (currentUser.isUser()) {
                printUserMenu();
                choice = input.acceptChoice();
                if (choice < 7 && choice >= 0) {
                    dispatcher.dispatch(choice, currentUser);
                }
                else if (choice == 7)
                    break;
            }
        }
    }

    private void printUserMenu() {
        view.printMessage("\n=====================================================================\n");
        view.printMessage("\n\t\tMenu\n");
        view.printMessage("\n=====================================================================\n");
        view.printMessage("\t0.My Profile\n\t1.List of Books\n\t2.Checkout Book\n\t3.Return Book\n\t");
        view.printMessage("4.List of Movies\n\t5.Checkout Movie\n\t6.Return Movie\n");
        view.printMessage("\t7.Logout\n\t");
        view.printMessage("Enter your choice:\n\t");

    }

    private void printAdminMenu() {
        view.printMessage("\n=====================================================================\n");
        view.printMessage("\n\t\tMenu\n");
        view.printMessage("\n=====================================================================\n");
        view.printMessage("\t0.My Profile\n\t1.List of Books\n\t2.Checkout Book\n\t3.Return Book\n\t");
        view.printMessage("4.List of Movies\n\t5.Checkout Movie\n\t6.Return Movie\n");
        view.printMessage("\t7.List Checkout Books\n\t8.List checkout Movies\n");
        view.printMessage("\t9.Logout\n\t");
        view.printMessage("Enter your choice:\n");
    }
}

