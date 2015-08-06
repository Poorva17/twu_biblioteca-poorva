package com.twu.biblioteca;

public class UserMenuView implements IView {
    Input input;
    Dispatcher dispatcher;

    public UserMenuView(Input input, Dispatcher dispatcher) {
        this.input = input;
        this.dispatcher = dispatcher;
    }

    public void render(User currentUser) {
        while(true) {
            System.out.print("\n=====================================================================\n");
            System.out.print("\n\t\tMenu\n");
            System.out.print("\n=====================================================================\n");
            System.out.print("\t0.My Profile\n\t1.List of Books\n\t2.Checkout Book\n\t3.Return Book\n\t");
            System.out.print("4.List of Movies\n\t5.Checkout Movie\n\t6.Return Movie\n");
            System.out.print("\t7.Logout\n\t");
            System.out.print("Enter your choice:\n\t\t");
            int choice = input.acceptChoice();
            if (choice == 7)
                break;
            dispatcher.dispatch(choice, currentUser);
        }
    }
}
