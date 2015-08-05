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
            int choice;
            boolean untilLogout = true;
            while (untilLogout) {
                if (currentUser.getRole().equals("admin")) {
                    printAdminMenu();
                    view.printMessage("\t9.Logout\n\t");
                    view.printMessage("Enter your choice:\n");
                    choice = input.acceptChoice();
                    if (choice == 9)
                        untilLogout = false;
                    view.printMessage("\n============================================================\n\n");
                    dispatcher.dispatch(choice, currentUser);
                } else if (currentUser.getRole().equals("user")) {
                    printUserMenu();
                    view.printMessage("\t7.Logout\n\t");
                    view.printMessage("Enter your choice:\n\t");
                    choice = input.acceptChoice();
                    if (choice < 7 && choice >= 0) {
                        view.printMessage("\n============================================================\n\n");
                        dispatcher.dispatch(choice, currentUser);
                    } else if (choice == 7)
                        untilLogout = false;
                    else
                        view.printMessage("\tSelect valid option!\n");
                } else
                    untilLogout = false;
            }

        }
    }

    private void printUserMenu() {
        view.printMessage("\n\t\tMenu\n");
        view.printMessage("\n=====================================================================\n");
        view.printMessage("\t0.My Profile\n\t1.List of Books\n\t2.Checkout Book\n\t3.Return Book\n\t");
        view.printMessage("4.List of Movies\n\t5.Checkout Movie\n\t6.Return Movie\n");

    }

    private void printAdminMenu() {
        printUserMenu();
        view.printMessage("\t7.List Checkout Books\n\t8.List checkout Movies\n");
    }
}

