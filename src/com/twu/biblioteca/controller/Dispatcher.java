package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Section;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.View;


public class Dispatcher {

    private View view;
    private Section bookLibrary;
    private Section movieLibrary;
    private Input input;

    public Dispatcher(View view, Section bookLibrary, Section movieLibrary, Input input) {
        this.view = view;
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.input = input;
    }

    public void dispatch(int choice, User currentUser) {
        if(validChoice(choice, currentUser)) {
            switch (choice) {
                case 0:
                    view.printMessage(String.format("\n\n%-20s %-10s %-30s %-20s\n", "Library No", "Name", "Email", "Contact No"));
                    view.printMessage("--------------------------------------------------------------------------------\n");
                    view.printMessage(currentUser.displayInformation());
                    break;
                case 1:
                    view.printMessage(String.format("\n\n\n%-20s %-20s %-20s\n", "Book Title", "Author", "Year Published"));
                    view.printMessage("-------------------------------------------------------------------------\n");
                    view.printListOfBooks(bookLibrary.getAvailableItemList());
                    break;
                case 2:
                    view.printMessage("Enter book name:\n\t\t");
                    String bookNameToCheckout = input.acceptInput();
                    view.printBookCheckoutStatus(bookLibrary.itemCheckout(bookNameToCheckout, currentUser));
                    break;
                case 3:
                    view.printMessage("Enter book name:\n\t\t");
                    String bookNameToCheckin = input.acceptInput();
                    view.printBookCheckinStatus( bookLibrary.itemCheckin(bookNameToCheckin, currentUser));
                    break;
                case 4:
                    view.printMessage(String.format("\n%-20s %-20s %-20s %-20s\n", "Movie Title", "Year published", "Director", "Movie Rating"));
                    view.printMessage("-----------------------------------------------------------------------------------\n");
                    view.printListOfMovies(movieLibrary.getAvailableItemList());
                    break;
                case 5:
                    view.printMessage("Enter movie name:\n\t\t");
                    String movieNameToCheckout = input.acceptInput();
                    view.printMovieCheckoutStatus(movieLibrary.itemCheckout(movieNameToCheckout, currentUser));
                    break;
                case 6:
                    view.printMessage("Enter movie name:\n\t\t");
                    String movieNameToCheckin = input.acceptInput();
                    view.printMovieCheckinStatus( movieLibrary.itemCheckin(movieNameToCheckin, currentUser));
                    break;
                case 7:
                    view.printMessage("\n\nList of Checkout Books\n");
                    view.printMessage(String.format("\n%-10s %-10s %-20s %-20s %-20s\n", "Library No", "Name", "Book Title", "Author", "Year Published\n"));
                    view.printMessage("-----------------------------------------------------------------------------------\n");
                    view.printHashMapBook(movieLibrary.getCheckoutList());
                    break;
                case 8:
                    view.printMessage("List of Checkout Movies\n");
                    view.printMessage(String.format("\n\n\n%-20s %-20s %-20s %-20s", "Movie Title", "Year published", "Director", "Movie Rating\n"));
                    view.printMessage("------------------------------------------------------------------------------------\n");
                    view.printHashMapMovie(movieLibrary.getCheckoutList());
                    break;
                default:
                    view.printMessage("Select valid option!\n");
            }
        }
    }

    private boolean validChoice(int choice, User currentUser) {
        if (currentUser.isUser() && choice >= 0 && choice <= 6)
            return true;
        else if (currentUser.isAdmin() && choice >= 0 && choice <= 8)
            return true;
        System.out.print("Invalid choice");
        return false;
    }
}