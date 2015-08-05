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
        view.printMessage("1. Login\n");
        view.printMessage("2.Quit\n");
        view.printMessage("Enter your choice:");
        int continueApp = input.acceptChoice();
        if (continueApp == 2) {
            System.exit(0);
        }
        while (continueApp == 1) {
            User currentUser = login.checkLogin();
            int choice;
            boolean untilLogout = true;
            while (untilLogout) {
                if (currentUser.getRole().equals("admin")) {
                    view.printMessage("Menu\n");
                    view.printMessage("-----------------------------------------------\n");
                    view.printMessage("1.List of Books\n" + "2.Checkout Book\n" + "3.Return Book\n" +
                            "4.List of Movies\n" + "5.Checkout Movie\n" + "6.Return Movie\n" + "7.List Checkout Books\n" + "8.List checkout Movies\n" + "9.Logout\n");
                    view.printMessage("Enter your choice:\n");
                    choice = input.acceptChoice();
                    if (choice == 9)
                        untilLogout = false;
                    dispatcher.dispatch(choice);
                    view.printMessage("\n-----------------------------------------------\n\n");
                } else if (currentUser.getRole().equals("user")) {
                    view.printMessage("Menu\n");
                    view.printMessage("-----------------------------------------------\n");
                    view.printMessage("1.List of Books\n" + "2.Checkout Book\n" + "3.Return Book\n" +
                            "4.List of Movies\n" + "5.Checkout Movie\n" + "6.Return Movie\n" + "7.Logout\n");
                    view.printMessage("Enter your choice:\n");
                    choice = input.acceptChoice();
                    if (choice < 7 && choice >= 1)
                        dispatcher.dispatch(choice);
                    else if (choice == 7)
                        untilLogout = false;
                    else
                        view.printMessage("Select valid option!\n");
                    view.printMessage("\n-----------------------------------------------\n\n");
                }
                else
                    untilLogout = false;
            }
            view.printMessage("1. Login\n");
            view.printMessage("2.Quit\n");
            view.printMessage("Enter your choice:");
            continueApp = input.acceptChoice();
            if (continueApp == 2) {
                System.exit(0);
            }
        }
    }
}

